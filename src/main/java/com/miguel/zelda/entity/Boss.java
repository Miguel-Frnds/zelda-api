package com.miguel.zelda.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "bosses")
public class Boss {

    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToMany
    @JoinTable(
            name = "game_boss",
            joinColumns = @JoinColumn(name = "boss_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id")
    )
    private List<Game> games;

    @ManyToMany
    @JoinTable(
            name = "boss_dungeon",
            joinColumns = @JoinColumn(name = "boss_id"),
            inverseJoinColumns = @JoinColumn(name = "dungeon_id")
    )
    private List<Dungeon> dungeons;
}
