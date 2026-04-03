package com.miguel.zelda.controller;

import com.miguel.zelda.dto.response.GameResponseDTO;
import com.miguel.zelda.service.GameService;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<List<GameResponseDTO>> findAllGames(){
        List<GameResponseDTO> games = gameService.findAllGames();
        return ResponseEntity.ok().body(games);
    }

    @GetMapping("/{gameId}")
    public ResponseEntity<GameResponseDTO> findGameById(@PathVariable("gameId") @NotBlank String id){
        GameResponseDTO game = gameService.findGameById(id);
        return ResponseEntity.ok().body(game);
    }

    @GetMapping("/name")
    public ResponseEntity<GameResponseDTO> findGameByName(@RequestParam @NotBlank String name){
        GameResponseDTO game = gameService.findGameByName(name);
        return ResponseEntity.ok().body(game);
    }

    @GetMapping("/latest")
    public ResponseEntity<GameResponseDTO> findLatestGame(){
        GameResponseDTO game = gameService.findLatestGame();
        return ResponseEntity.ok().body(game);
    }

    @GetMapping("/random")
    public ResponseEntity<GameResponseDTO> findRandomGame(){
        GameResponseDTO game = gameService.findRandomGame();
        return ResponseEntity.ok().body(game);
    }
}
