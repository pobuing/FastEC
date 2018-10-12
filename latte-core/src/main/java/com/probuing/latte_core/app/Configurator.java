package com.probuing.latte_core.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.WeakHashMap;

/**
 * @author wxblack-mac
 * @DATE 2018/10/12 16:57
 * @DESCRIBE: 配置类
 * GOOD LUCK
 */
public final class Configurator {
    private static final WeakHashMap<String, Object> LATTE_CONFIGS = new WeakHashMap<String, Object>();
    //定义存储字体图标空间
    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<IconFontDescriptor>();

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
        initIcons();

        //更改配置准备状态
        LATTE_CONFIGS.put(ConfiguraType.CONFIG_READY.name(), true);
    }

    /**
     * 图标初始化
     */
    private void initIcons() {
        if (ICONS.size() > 0) {
            Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i = 1; i < ICONS.size(); i++) {
                initializer.with(ICONS.get(i));
            }
        }
    }

    /**
     * 添加字体图标
     *
     * @param descriptor 字体图标
     * @return configurator
     */
    public final Configurator withIcon(IconFontDescriptor descriptor) {
        ICONS.add(descriptor);
        return this;
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
