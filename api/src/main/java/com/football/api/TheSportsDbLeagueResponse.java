package com.football.api;

import java.util.List;

public record TheSportsDbLeagueResponse(
        List<LeagueDto> leagues
) {
}
