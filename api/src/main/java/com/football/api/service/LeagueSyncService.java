package com.football.api.service;

import com.football.api.dto.LeagueInfo;
import com.football.api.global.config.exception.ExternalApiUnavailableException;
import com.football.api.global.feign.application.TheSportsDbAdapter;
import com.football.core.command.LeagueSyncCommand;
import com.football.core.command.LeagueCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LeagueSyncService {
    private final LeagueCommandService leagueCommandService;
    private final TheSportsDbAdapter theSportsDbAdapter;

    public LeagueInfo sync(String leagueId) {
        LeagueInfo leagueInfo = theSportsDbAdapter.sync(leagueId);

        leagueCommandService.create(
                new LeagueSyncCommand(
                        leagueInfo.leagueId(),
                        leagueInfo.leagueName(),
                        leagueInfo.leagueAlternateName(),
                        leagueInfo.currentSeason(),
                        leagueInfo.country(),
                        leagueInfo.website(),
                        leagueInfo.badge(),
                        leagueInfo.logo()
                )
        );
        return leagueInfo;
    }
}
