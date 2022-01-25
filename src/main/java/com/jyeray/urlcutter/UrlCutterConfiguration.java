package com.jyeray.urlcutter;

import com.jyeray.urlcutter.domain.ShortcutRepository;
import com.jyeray.urlcutter.repositories.ShortcutRepositoryInMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UrlCutterConfiguration {

    @Bean
    public ShortcutRepository shortcutRepository() {
        return new ShortcutRepositoryInMemory();
    }
}
