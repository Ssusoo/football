package com.football.api.global.feign.dto;

import java.util.List;

public record TheSportsDbLeagueResponse(
        List<LeagueDto> leagues
) {
}
