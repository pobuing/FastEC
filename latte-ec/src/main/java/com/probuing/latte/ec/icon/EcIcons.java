package com.probuing.latte.ec.icon;

import com.joanzapata.iconify.Icon;

/**
 * @author wxblack-mac
 * @DATE 2018/10/15 14:13
 * @DESCRIBE: ${?}
 * GOOD LUCK
 */
public enum EcIcons implements Icon {
    icon_scan('\ue606'), icon_ali_pay('\ue606');
    private char character;

    EcIcons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_', '-');

    }

    @Override
    public char character() {
        return character;
    }
}
