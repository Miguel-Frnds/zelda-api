package com.miguel.zelda.client;

import com.miguel.zelda.dto.api.GameApiDTO;
import com.miguel.zelda.dto.api.ZeldaApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "zeldafanapi", url = "https://zelda.fanapis.com/api")
public interface ZeldaApiClient {

    @RequestMapping("/games")
    ZeldaApiResponse<GameApiDTO> getGames();
}
