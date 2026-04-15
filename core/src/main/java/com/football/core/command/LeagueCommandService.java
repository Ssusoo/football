package com.football.core.command;

import com.football.core.domain.League;
import com.football.core.repository.LeagueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LeagueCommandService {
    private final LeagueRepository leagueRepository;

    @Transactional
    public void create(LeagueSyncCommand leagueSyncCommand) {
        League league = leagueRepository.findByLeagueId(leagueSyncCommand.leagueId())
                .map(existingLeague -> {
                    existingLeague.update(
                            leagueSyncCommand.leagueName(),
                            leagueSyncCommand.leagueAlternateName(),
                            leagueSyncCommand.currentSeason(),
                            leagueSyncCommand.country(),
                            leagueSyncCommand.website(),
                            leagueSyncCommand.badge(),
                            leagueSyncCommand.logo()
                    );
                    return existingLeague;
                })
                .orElseGet(() -> League.create(
                        leagueSyncCommand.leagueId(),
                        leagueSyncCommand.leagueName(),
                        leagueSyncCommand.leagueAlternateName(),
                        leagueSyncCommand.currentSeason(),
                        leagueSyncCommand.country(),
                        leagueSyncCommand.website(),
                        leagueSyncCommand.badge(),
                        leagueSyncCommand.logo()
                ));
        leagueRepository.save(league);
    }
}
