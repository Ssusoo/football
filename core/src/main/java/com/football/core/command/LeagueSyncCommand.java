package com.football.core.command;

public record LeagueSyncCommand(
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
