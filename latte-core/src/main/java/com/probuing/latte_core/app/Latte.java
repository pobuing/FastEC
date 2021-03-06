package com.probuing.latte_core.app;

import android.content.Context;

import java.util.HashMap;

/**
 * @author wxblack-mac
 * @DATE 2018/10/12 16:55
 * @DESCRIBE: 框架配置类
 * 该类中定义框架初始化方法
 * GOOD LUCK
 */
public final class Latte {
    public static Configurator init(Context context) {
        getConfigurations().put(ConfigKeys.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static HashMap<Object, Object> getConfigurations() {
        return Configurator.getInstance().getLatteConfigs();
    }

    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }

    public static Context getApplicationContext() {
        return (Context) getConfigurations().get(ConfigKeys.APPLICATION_CONTEXT.name());
    }
}
