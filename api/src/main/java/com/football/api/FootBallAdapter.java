package com.football.api;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Validated
@Component
@RequiredArgsConstructor
@Slf4j
public class FootBallAdapter {
    private final FootballClient footballClient;

    public LeagueInfo getLeague(String leagueId) throws ExternalApiUnavailableException {
        try {
            TheSportsDbLeagueResponse response = footballClient.getKoreanLeague(leagueId);

            if (response == null) {
                throw new ExternalApiUnavailableException("사이트에서 존재하지 않는 요청입니다.");
            }

            LeagueDto league = response.leagues().get(0);

            return new LeagueInfo(
                    league.idLeague(),
                    league.strLeague(),
                    league.strLeagueAlternate(),
                    league.strCurrentSeason(),
                    league.strCountry(),
                    league.strWebsite(),
                    league.strBadge(),
                    league.strLogo()
            );
        } catch (FeignException e) {
            log.error("FootBallAdapter", e);
            throw new ExternalApiUnavailableException(e.getMessage());
        }
    }
}
