package com.football.api.domains.league.dto;

public record LeagueInfo(
        String leagueId,
        String leagueName,
        String leagueAlternateName,
        String currentSeason,
        String country,
        String website,
        String badge,
        String logo
) {
}
