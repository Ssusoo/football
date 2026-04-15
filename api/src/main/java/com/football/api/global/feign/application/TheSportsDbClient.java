package com.football.api.global.feign.application;

import com.football.api.global.feign.dto.TheSportsDbLeagueResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "theSportsDbClient", url="${external-api.the-sports-db.host}")
public interface TheSportsDbClient {
    @GetMapping(value = "${external-api.the-sports-db.korean-league-path}")
    TheSportsDbLeagueResponse getKoreanLeague(@RequestParam("id") String leagueId);
}
