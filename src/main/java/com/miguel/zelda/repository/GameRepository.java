package com.miguel.zelda.repository;

import com.miguel.zelda.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, String> {
    Optional<Game> findByName(String name);
    Optional<Game> findTopByOrderByReleasedDateDesc();
}
