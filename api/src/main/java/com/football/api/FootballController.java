package com.football.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FootballController {
    private final FootBallAdapter footBallAdapter;

    @GetMapping("/football/korean-league")
    public LeagueInfo getKoreanLeague() throws ExternalApiUnavailableException {
        return footBallAdapter.getKoreanLeagueTeams();
    }
}
