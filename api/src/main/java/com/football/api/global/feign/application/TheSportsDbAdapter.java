package com.football.api.global.feign.application;

import com.football.api.dto.LeagueInfo;
import com.football.api.global.feign.dto.TheSportsDbLeagueResponse;
import com.football.api.global.config.exception.ExternalApiUnavailableException;
import com.football.api.global.feign.dto.LeagueDto;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Validated
@Component
@RequiredArgsConstructor
@Slf4j
public class TheSportsDbAdapter {
    private final TheSportsDbClient theSportsDbClient;

    public LeagueInfo sync(String leagueId) throws ExternalApiUnavailableException {
        try {
            TheSportsDbLeagueResponse response = theSportsDbClient.getKoreanLeague(leagueId);

            if (response == null || response.leagues() == null || response.leagues().isEmpty()) {
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
            log.error("TheSportsDbAdapter", e);
            throw new ExternalApiUnavailableException(e.getMessage());
        }
    }
}
