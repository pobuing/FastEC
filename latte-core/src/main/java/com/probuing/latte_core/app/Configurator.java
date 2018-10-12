package com.probuing.latte_core.app;

import java.util.WeakHashMap;

/**
 * @author wxblack-mac
 * @DATE 2018/10/12 16:57
 * @DESCRIBE: 配置类
 * GOOD LUCK
 */
public final class Configurator {
    private static final WeakHashMap<String, Object> LATTE_CONFIGS = new WeakHashMap<String, Object>();


    public Configurator() {
        //重置初始化默认状态
        LATTE_CONFIGS.put(ConfiguraType.CONFIG_READY.name(), false);
    }

    /**
     * 获取实例 单例
     *
     * @return
     */
    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    public WeakHashMap<String, Object> getLatteConfigs() {
        return LATTE_CONFIGS;
    }


    /**
     * 静态内部类 单例模式初始化
     */
    private static final class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    /**
     * 配置方法
     */
    public final void configure() {
        //更改配置准备状态
        LATTE_CONFIGS.put(ConfiguraType.CONFIG_READY.name(), true);
    }

    public final Configurator withApiHost(String host) {
        LATTE_CONFIGS.put(ConfiguraType.API_HOST.name(), host);
        return this;
    }

    /**
     * 配置检测
     */
    private void checkConfiguration() {
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfiguraType.CONFIG_READY.name());
        if (!isReady) {
            //未准备就绪
            throw new RuntimeException("configuration is not ready,call configure");
        }
    }


    /**
     * 获取对应key的配置
     *
     * @param key key
     * @param <T> 枚举配置
     * @return 配置的值
     */
    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Enum<ConfiguraType> key) {
        checkConfiguration();
        return (T) LATTE_CONFIGS.get(key.name());
    }
}
