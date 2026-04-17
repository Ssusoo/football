package com.football.core.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeagueTest {
    @DisplayName("리그 생성")
    @Test
    void create() {
        // given
        String leagueId = "4328";
        String leagueName = "Koran K League 1";
        String leagueAlternateName = "K League 1";
        String currentSeason = "2026";
        String country = "South Korea";
        String website = "https://www.kleague.com";
        String badge = "badge-url";
        String logo = "logo-url";

        // when
        League league = League.create(
                leagueId,
                leagueName,
                leagueAlternateName,
                currentSeason,
                country,
                website,
                badge,
                logo
        );

        // then
        assertEquals("4328", league.getLeagueId());
        assertEquals("Koran K League 1", league.getLeagueName());
        assertEquals("K League 1", league.getLeagueAlternateName());
        assertEquals("2026", league.getCurrentSeason());
        assertEquals("South Korea", league.getCountry());
        assertEquals("https://www.kleague.com", league.getWebsite());
        assertEquals("badge-url", league.getBadge());
        assertEquals("logo-url", league.getLogo());
    }
}