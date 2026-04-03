package com.miguel.zelda.dto.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class GameApiDTO {
    private String id;
    private String name;
    private String description;
    private String developer;
    private String publisher;

    @JsonProperty("released_date")
    private String releasedDate;
}
