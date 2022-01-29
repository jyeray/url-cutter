package com.jyeray.urlcutter.actions;

import com.jyeray.urlcutter.domain.ShortcutRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CreateShortcutTest {

    private final ShortcutRepository shortcutRepository = mock(ShortcutRepository.class);
    private final CreateShortcut createShortcut = new CreateShortcut(shortcutRepository);

    @Test
    void create_a_shortcut_for_a_destination_url() {
        var destinationUrl = "https://joaquinmartin.dev";

        var shortcut = createShortcut.execute(destinationUrl);

        assertThat(shortcut).isNotEmpty();
        verify(shortcutRepository).create(shortcut, destinationUrl);
    }
}