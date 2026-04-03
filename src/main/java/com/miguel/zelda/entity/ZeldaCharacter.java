package com.miguel.zelda.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "zelda_characters")
public class ZeldaCharacter {

    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    private String description;
    private String gender;
    private String race;

    @ManyToMany
    @JoinTable(
            name = "game_character",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id")
    )
    private List<Game> games;
}
