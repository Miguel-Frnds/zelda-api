package com.miguel.zelda.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "items")
public class Item {

    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToMany
    @JoinTable(
            name = "game_item", // nome da tabela intermediaria
            joinColumns = @JoinColumn(name = "item_id"), // chave do lado de Item
            inverseJoinColumns = @JoinColumn(name = "game_id") // chave do lado de Game
    )
    private List<Game> games;
}
