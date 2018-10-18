package com.probuing.latte_core.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.probuing.latte_core.app.Latte;

/**
 * @author wxblack-mac
 * @DATE 2018/10/18 10:56
 * @DESCRIBE: 测量工具类
 * GOOD LUCK
 */
public class DimenUtil {
    /**
     * 测量屏幕宽
     *
     * @return
     */
    public static int getScreenWidth() {
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    /**
     * 测量屏幕高
     *
     * @return
     */
    public static int getScreenHeight() {
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
