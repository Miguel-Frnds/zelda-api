package com.miguel.zelda.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class GameResponseDTO {
    private String id;
    private String name;
    private String description;
    private String developer;
    private String publisher;
    private LocalDate releasedDate;
}
