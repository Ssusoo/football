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
        assertAll(
                () -> assertEquals("4328", league.getLeagueId()),
                () -> assertEquals("Koran K League 1", league.getLeagueName()),
                () -> assertEquals("K League 1", league.getLeagueAlternateName()),
                () -> assertEquals("2026", league.getCurrentSeason()),
                () -> assertEquals("South Korea", league.getCountry()),
                () -> assertEquals("https://www.kleague.com", league.getWebsite()),
                () -> assertEquals("badge-url", league.getBadge()),
                () -> assertEquals("logo-url", league.getLogo())
        );
    }

    @Test
    @DisplayName("update: 변경 가능한 필드를 수정한다")
    void updateLeague() {
        // given
        League league = League.create(
                "4328",
                "Korean K League 1",
                "K League 1",
                "2026",
                "South Korea",
                "https://www.kleague.com",
                "badge-url",
                "logo-url"
        );

        // when
        league.update(
                "Korean K League 1 Updated",
                "K League 1 Updated",
                "2027",
                "Republic of Korea",
                "https://new.kleague.com",
                "new-badge-url",
                "new-logo-url"
        );

        // then
        assertAll(
                () -> assertEquals("4328", league.getLeagueId()),
                () -> assertEquals("Korean K League 1 Updated", league.getLeagueName()),
                () -> assertEquals("K League 1 Updated", league.getLeagueAlternateName()),
                () -> assertEquals("2027", league.getCurrentSeason()),
                () -> assertEquals("Republic of Korea", league.getCountry()),
                () -> assertEquals("https://new.kleague.com", league.getWebsite()),
                () -> assertEquals("new-badge-url", league.getBadge()),
                () -> assertEquals("new-logo-url", league.getLogo())
        );
    }
}