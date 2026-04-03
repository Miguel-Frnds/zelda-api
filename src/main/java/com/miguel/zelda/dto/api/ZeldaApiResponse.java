package com.miguel.zelda.dto.api;

import lombok.Getter;

import java.util.List;

@Getter
public class ZeldaApiResponse<T> {
    private boolean success;
    private int count;
    private List<T> data;
}
