package com.miguel.zelda.service;

import com.miguel.zelda.client.ZeldaApiClient;
import com.miguel.zelda.dto.api.GameApiDTO;
import com.miguel.zelda.dto.api.ZeldaApiResponse;
import com.miguel.zelda.mapper.GameMapper;
import com.miguel.zelda.dto.response.GameResponseDTO;
import com.miguel.zelda.entity.Game;
import com.miguel.zelda.repository.GameRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class GameService {

    private final ZeldaApiClient zeldaApiClient;

    private final GameRepository gameRepository;

    public GameService(ZeldaApiClient zeldaApiClient, GameRepository gameRepository){
        this.zeldaApiClient = zeldaApiClient;
        this.gameRepository = gameRepository;
    }

    @PostConstruct
    public void init() {
        syncGame();
    }


    public void syncGame() {
        if(gameRepository.count() > 0) return;

        ZeldaApiResponse<GameApiDTO> response = zeldaApiClient.getGames();
        List<GameApiDTO> games = response.getData();
        List<Game> gameList = games.stream().map(GameMapper::toEntity).toList();
        gameRepository.saveAll(gameList);
    }

    public List<GameResponseDTO> findAllGames(){
        return gameRepository.findAll().stream()
                .map(GameMapper::toResponseDTO)
                .toList();
    }

    public GameResponseDTO findGameById(String id) {
        Game gameFound = gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game not found"));
        return GameMapper.toResponseDTO(gameFound);
    }

    public GameResponseDTO findGameByName(String name){
        Game gameFound = gameRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Game not found with this name"));

        return GameMapper.toResponseDTO(gameFound);
    }

    public GameResponseDTO findLatestGame(){
        Game gameFound = gameRepository.findTopByReleasedDateIsNotNullOrderByReleasedDateDesc()
                .orElseThrow(() -> new RuntimeException("No games found in the database"));

        return GameMapper.toResponseDTO(gameFound);
    }

    public GameResponseDTO findRandomGame(){
        List<Game> games = gameRepository.findAll();

        if(games.isEmpty()){
            throw new RuntimeException("No games found in the database");
        }

        int randomIndex = new Random().nextInt(games.size());
        return GameMapper.toResponseDTO(games.get(randomIndex));
    }
}
