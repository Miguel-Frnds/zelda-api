package com.miguel.zelda.mapper;

import com.miguel.zelda.dto.api.GameApiDTO;
import com.miguel.zelda.dto.response.GameResponseDTO;
import com.miguel.zelda.entity.Game;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class GameMapper {
    public static Game toEntity(GameApiDTO api){
        Game game = new Game();
        game.setId(api.getId());
        game.setName(api.getName());
        game.setDescription(api.getDescription());
        game.setPublisher(api.getPublisher());
        game.setDeveloper(api.getDeveloper());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy").withLocale(Locale.US);
        LocalDate date = LocalDate.parse(api.getReleasedDate().trim(), formatter);
        game.setReleasedDate(date);

        return game;
    }

    public static GameResponseDTO toResponseDTO(Game game){
        return new GameResponseDTO(
                game.getId(),
                game.getName(),
                game.getDescription(),
                game.getDeveloper(),
                game.getPublisher(),
                game.getReleasedDate()
        );
    }
}
