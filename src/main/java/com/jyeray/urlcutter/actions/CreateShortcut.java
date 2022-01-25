package com.jyeray.urlcutter.actions;

import com.jyeray.urlcutter.domain.ShortcutRepository;
import org.apache.commons.lang3.RandomStringUtils;

public class CreateShortcut {

    private final ShortcutRepository shortcutRepository;

    public CreateShortcut(ShortcutRepository shortcutRepository) {
        this.shortcutRepository = shortcutRepository;
    }

    public String execute(String destinationUrl) {
        var shortcutPath = generateShortcutPath();
        shortcutRepository.create(shortcutPath, destinationUrl);
        return shortcutPath;
    }

    private String generateShortcutPath() {
        return RandomStringUtils.random(3, true, true);
    }

}
