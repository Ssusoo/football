package com.football.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "footballClient", url="${external-api.the-sports-db.host}")
public interface FootballClient {
    @GetMapping(value = "${external-api.the-sports-db.korean-league-path}")
    TheSportsDbLeagueResponse getKoreanLeague(@RequestParam("id") String leagueId);
}
