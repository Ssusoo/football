package com.football.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FootballController {
    private final FootBallAdapter footBallAdapter;

    @GetMapping("/football/korean-league")
    public LeagueInfo getKoreanLeague(@RequestParam("id") String leagueId) throws ExternalApiUnavailableException {
        return footBallAdapter.getLeague(leagueId);
    }
}
