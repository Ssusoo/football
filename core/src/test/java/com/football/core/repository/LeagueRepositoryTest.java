package com.football.core.repository;

import com.football.core.domain.League;
import com.football.core.test.RepositoryTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static com.football.core.setup.LeagueDomainSetup.getLeagueBuilder;
import static org.junit.jupiter.api.Assertions.*;

class LeagueRepositoryTest extends RepositoryTest {
    @Autowired
    private LeagueRepository leagueRepository;

    @BeforeEach
    void setUp() {
        super.getDatabaseCleaner().truncateAll();
        super.getEntityManager().persist(getLeagueBuilder().build());
    }

    @Test
    @DisplayName("리그 조회 - 성공")
    void find_league_id() {
        // when
        Optional<League> league = leagueRepository.findByLeagueId("4328");

        // then
        assertTrue(league.isPresent());
    }

    @Test
    @DisplayName("리그 조회(리그 아이디) - 실패")
    void find_league_id_fail() {
        // when
        var league = leagueRepository.findByLeagueId("7777");

        // then
        assertTrue(league.isEmpty());
    }
}