package com.probuing.fastec;

import android.app.Application;

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
                .withApiHost("http://mock.fulingjie.com/mock/api/");
    }
}
