package com.jyeray.urlcutter.repositories;

import com.jyeray.urlcutter.domain.ShortcutRepository;

import java.util.concurrent.ConcurrentHashMap;

public class ShortcutRepositoryInMemory implements ShortcutRepository {

    private static final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    @Override
    public void create(String shortcutPath, String destinationUrl) {
        map.put(shortcutPath, destinationUrl);
    }

    @Override
    public String getDestinationUrlFor(String shortcutPath) {
        return map.get(shortcutPath);
    }
}
