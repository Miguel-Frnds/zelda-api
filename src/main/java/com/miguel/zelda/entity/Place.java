package com.miguel.zelda.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "places")
public class Place {

    @Id
    private String id;

    @Column(nullable = false)
    private String name;
    private String description;

    @ManyToMany
    @JoinTable(
            name = "game_place",
            joinColumns = @JoinColumn(name = "place_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id")
    )
    private List<Game> games;

    @ManyToMany
    @JoinTable(
            name = "character_place",
            joinColumns = @JoinColumn(name = "place_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id")
    )
    private List<ZeldaCharacter> characters;
}
