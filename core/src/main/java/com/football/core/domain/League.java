package com.football.core.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "football_leagues")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
public class League {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "league_id", nullable = false)
    private String leagueId;

    @Column(name = "league_nm", nullable = false)
    private String leagueName;

    @Column(name = "league_alt_nm", nullable = false)
    private String leagueAlternateName;

    @Column(name = "curr_season", nullable = false)
    private String currentSeason;

    @Column(name = "country_nm", nullable = false)
    private String country;

    @Column(name = "website_url", nullable = false)
    private String website;

    @Column(name = "badge_url", nullable = false)
    private String badge;

    @Column(name = "logo_url", nullable = false)
    private String logo;

    public static League create(
            String leagueId,
            String leagueName,
            String leagueAlternateName,
            String currentSeason,
            String country,
            String website,
            String badge,
            String logo
    ) {
        return League.builder()
                .leagueId(leagueId)
                .leagueName(leagueName)
                .leagueAlternateName(leagueAlternateName)
                .currentSeason(currentSeason)
                .country(country)
                .website(website)
                .badge(badge)
                .logo(logo)
                .build();
    }

    public void update(
            String leagueName,
            String leagueAlternateName,
            String currentSeason,
            String country,
            String website,
            String badge,
            String logo
    ) {
        this.leagueName = leagueName;
        this.leagueAlternateName = leagueAlternateName;
        this.currentSeason = currentSeason;
        this.country = country;
        this.website = website;
        this.badge = badge;
        this.logo = logo;
    }
}
