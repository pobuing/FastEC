package com.probuing.fastec;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.probuing.latte.ec.icon.FontEcModule;
import com.probuing.latte_core.app.Latte;


/**
 * @author wxblack-mac
 * @DATE 2018/10/12 17:16
 * @DESCRIBE: 应用程序
 * GOOD LUCK
 */
public class AppApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //框架初始化
        Latte.init(this)
                .withApiHost("http://mock.fulingjie.com/mock/api/")
                //加入默认字体图标
                .withIcon(new FontAwesomeModule())
                //加入自定义字体图标
                .withIcon(new FontEcModule())
                .configure();
    }
}
