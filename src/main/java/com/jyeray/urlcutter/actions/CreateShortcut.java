package com.jyeray.urlcutter.actions;

import com.jyeray.urlcutter.domain.ShortcutGenerator;
import com.jyeray.urlcutter.domain.ShortcutRepository;

public class CreateShortcut {

    private final ShortcutRepository shortcutRepository;
    private final ShortcutGenerator shortcutGenerator;

    public CreateShortcut(ShortcutRepository shortcutRepository, ShortcutGenerator shortcutGenerator) {
        this.shortcutRepository = shortcutRepository;
        this.shortcutGenerator = shortcutGenerator;
    }

    public String execute(String destinationUrl) {
        var shortcutPath = shortcutGenerator.generateShortcutPath();
        shortcutRepository.create(shortcutPath, destinationUrl);
        return shortcutPath;
    }
}
