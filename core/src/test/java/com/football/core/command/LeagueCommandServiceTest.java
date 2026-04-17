package com.football.core.command;

import com.football.core.domain.League;
import com.football.core.repository.LeagueRepository;
import com.football.core.test.MockTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.BDDMockito.then;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.*;

class LeagueCommandServiceTest extends MockTest {
    @InjectMocks
    private LeagueCommandService leagueCommandService;

    @Mock
    private LeagueRepository leagueRepository;

    @Test
    @DisplayName("리그 생성 - 기존 리그가 없으면 새로 생성하여 저장한다")
    void create_success() {
        // given
        LeagueSyncCommand leagueSyncCommand = getLeagueSyncCommand();
        given(leagueRepository.findByLeagueId(anyString())).willReturn(Optional.empty());
        given(leagueRepository.save(any(League.class)))
                .willAnswer(invocation -> invocation.getArgument(0));

        // when
        leagueCommandService.create(leagueSyncCommand);

        // then(ArgumentCaptor : 전달한 값을 잡는 도구,
        ArgumentCaptor<League> league = ArgumentCaptor.forClass(League.class);
        then(leagueRepository).should().save(league.capture());

        League savedLeague = league.getValue();

        assertAll(
                () -> assertEquals("4328", savedLeague.getLeagueId()),
                () -> assertEquals("Korean K League 1", savedLeague.getLeagueName()),
                () -> assertEquals("K League 1", savedLeague.getLeagueAlternateName()),
                () -> assertEquals("2026", savedLeague.getCurrentSeason()),
                () -> assertEquals("South Korea", savedLeague.getCountry()),
                () -> assertEquals("https://www.kleague.com", savedLeague.getWebsite()),
                () -> assertEquals("badge-url", savedLeague.getBadge()),
                () -> assertEquals("logo-url", savedLeague.getLogo())
        );
    }

    @Test
    @DisplayName("리그 수정 - 기존 리그가 있으면 정보를 수정하여 저장한다")
    void update_success() {
        // given
        LeagueSyncCommand command = getLeagueSyncCommand();

        League existingLeague = League.create(
                "4328",
                "Old League Name",
                "Old Alt Name",
                "2025",
                "Korea",
                "old-url",
                "old-badge",
                "old-logo"
        );

        given(leagueRepository.findByLeagueId(anyString())).willReturn(Optional.of(existingLeague));
        given(leagueRepository.save(any(League.class)))
                .willAnswer(invocation -> invocation.getArgument(0));

        // when
        leagueCommandService.create(command);

        // then
        ArgumentCaptor<League> league = ArgumentCaptor.forClass(League.class);
        then(leagueRepository).should().save(league.capture());

        League savedLeague = league.getValue();

        assertAll(
                () -> assertEquals("4328", savedLeague.getLeagueId()),
                () -> assertEquals("Korean K League 1", savedLeague.getLeagueName()),
                () -> assertEquals("K League 1", savedLeague.getLeagueAlternateName()),
                () -> assertEquals("2026", savedLeague.getCurrentSeason()),
                () -> assertEquals("South Korea", savedLeague.getCountry()),
                () -> assertEquals("https://www.kleague.com", savedLeague.getWebsite()),
                () -> assertEquals("badge-url", savedLeague.getBadge()),
                () -> assertEquals("logo-url", savedLeague.getLogo())
        );
    }

    @Test
    @DisplayName("리그 생성 - 성공")
    void success() {
        // given
        LeagueSyncCommand command = getLeagueSyncCommand();
        given(leagueRepository.findByLeagueId(anyString())).willReturn(Optional.empty());

        // when
        leagueCommandService.create(command);

        // then
        then(leagueRepository).should().save(any(League.class));
    }

    private LeagueSyncCommand getLeagueSyncCommand() {
        return new LeagueSyncCommand(
                "4328",
                "Korean K League 1",
                "K League 1",
                "2026",
                "South Korea",
                "https://www.kleague.com",
                "badge-url",
                "logo-url"
        );
    }

}