package com.jyeray.urlcutter.generators;

import com.jyeray.urlcutter.domain.ShortcutGenerator;
import org.apache.commons.lang3.RandomStringUtils;

public class ShortcutGeneratorRandomStringUtils implements ShortcutGenerator {

    @Override
    public String generateShortcutPath() {
        return RandomStringUtils.random(3, true, true);
    }
}