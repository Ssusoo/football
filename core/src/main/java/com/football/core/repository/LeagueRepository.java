package com.football.core.repository;

import com.football.core.base.repository.BaseRepository;
import com.football.core.domain.League;
import com.football.core.domain.QLeague;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class LeagueRepository extends BaseRepository<League, Long> {
    private final QLeague league = QLeague.league;

    public Optional<League> findByLeagueId(String leagueId) {
        return Optional.ofNullable(selectFrom(league)
                .where(league.leagueId.eq(leagueId))
                .fetchOne());
    }
}
