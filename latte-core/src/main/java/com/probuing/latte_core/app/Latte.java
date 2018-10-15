package com.probuing.latte_core.app;

import android.content.Context;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * @author wxblack-mac
 * @DATE 2018/10/12 16:55
 * @DESCRIBE: 框架配置类
 * 该类中定义框架初始化方法
 * GOOD LUCK
 */
public final class Latte {
    public static Configurator init(Context context) {
        getConfigurations().put(ConfiguraType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    private static HashMap<String, Object> getConfigurations() {
        return Configurator.getInstance().getLatteConfigs();
    }

    public static Context getApplicationContext() {
        return (Context) getConfigurations().get(ConfiguraType.APPLICATION_CONTEXT.name());
    }
}
