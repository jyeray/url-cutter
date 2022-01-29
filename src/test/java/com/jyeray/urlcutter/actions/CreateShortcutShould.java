package com.jyeray.urlcutter.actions;

import com.jyeray.urlcutter.domain.ShortcutGenerator;
import com.jyeray.urlcutter.domain.ShortcutRepository;
import com.jyeray.urlcutter.generators.ShortcutGeneratorRandomStringUtils;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class CreateShortcutTest {

    private final ShortcutRepository shortcutRepository = mock(ShortcutRepository.class);
    private final ShortcutGenerator shortcutGenerator = mock(ShortcutGenerator.class);
    private final CreateShortcut createShortcut = new CreateShortcut(shortcutRepository, shortcutGenerator);

    @Test
    void create_a_shortcut_for_a_destination_url() {
        var destinationUrl = "https://joaquinmartin.dev";
        var shortcutPath = "xyvzf";
        when(shortcutGenerator.generateShortcutPath()).thenReturn(shortcutPath);

        var shortcut = createShortcut.execute(destinationUrl);

        assertThat(shortcut).isEqualTo(shortcutPath);
        verify(shortcutRepository).create(shortcut, destinationUrl);
    }
}