package com.football.api.controller;

import com.football.api.dto.LeagueInfo;
import com.football.api.global.config.exception.ExternalApiUnavailableException;
import com.football.api.service.LeagueSyncService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FootballController {
    private final LeagueSyncService leagueSyncService;

    @PostMapping("/football/korean-league")
    public LeagueInfo syncKoreanLeague(@RequestParam("id") String leagueId) {
        return leagueSyncService.sync(leagueId);
    }
}
