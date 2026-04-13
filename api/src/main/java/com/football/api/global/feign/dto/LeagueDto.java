package com.football.api.global.feign.dto;

public record LeagueDto(
        String idLeague,
        String idAPIfootball,
        String idAPIfootballv3,
        String strSport,
        String strLeague,
        String strLeagueAlternate,
        String intDivision,
        String strCurrentSeason,
        String intFormedYear,
        String strGender,
        String strCountry,
        String strWebsite,
        String strDescriptionEN,
        String strBadge,
        String strLogo
) {
}
