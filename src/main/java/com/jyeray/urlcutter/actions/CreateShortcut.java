package com.jyeray.urlcutter.actions;

import com.jyeray.urlcutter.domain.ShortcutRepository;

import java.nio.charset.StandardCharsets;
import java.util.Random;

public class CreateShortcut {

    private final ShortcutRepository shortcutRepository;

    public CreateShortcut(ShortcutRepository shortcutRepository) {
        this.shortcutRepository = shortcutRepository;
    }

    public String execute(String destinationUrl) {
        String shortcutPath = generateShortcutPath();
        shortcutRepository.create(shortcutPath, destinationUrl);
        return shortcutPath;
    }

    private String generateShortcutPath() {
        byte[] array = new byte[3];
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.US_ASCII);
    }

}
