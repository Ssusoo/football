package com.football.core.setup;

import com.football.core.domain.League;

public class LeagueDomainSetup {
    public static League.LeagueBuilder getLeagueBuilder() {
        return League.builder()
                .leagueId("4328")
                .leagueAlternateName("Koran K League 1")
                .leagueName("K League 1")
                .currentSeason("2026")
                .country("South Korea")
                .website("https://www.kleague.com")
                .badge("badge-url")
                .logo("logo-url");
    }
}
