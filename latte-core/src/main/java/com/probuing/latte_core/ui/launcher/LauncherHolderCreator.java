package com.probuing.latte_core.ui.launcher;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;

/**
 * @author wxblack-mac
 * @DATE 2018/10/19 16:32
 * @DESCRIBE: ${?}
 * GOOD LUCK
 */
public class LauncherHolderCreator implements CBViewHolderCreator<LauncherHolder> {
    @Override
    public LauncherHolder createHolder() {
        return new LauncherHolder();
    }
}
