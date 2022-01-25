package com.jyeray.urlcutter.domain;

public interface ShortcutRepository {
    void create(String shortcutPath, String destinationUrl);

    String getDestinationUrlFor(String shortcutPath);
}
