package com.probuing.latte_core.ui;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.probuing.latte_core.R;
import com.probuing.latte_core.util.DimenUtil;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;

/**
 * @author wxblack-mac
 * @DATE 2018/10/18 10:29
 * @DESCRIBE: ${?}
 * GOOD LUCK
 */
public class LatteLoader {
    //设置缩放比
    private static final int LOADER_SIZE_SCALE = 8;
    //设置偏移量
    private static final int LOADER_OFFSET_SCALE = 10;

    private static final ArrayList<AppCompatDialog> LOADERS = new ArrayList<AppCompatDialog>();

    private static final String DEFAULT_LOADER = LoaderStyle.BallClipRotateIndicator.name();

    private static void showLoading(Context context, String type) {
        AppCompatDialog dialog = new AppCompatDialog(context, R.style.dialog);
        final AVLoadingIndicatorView avLoadingIndicatorView = LoaderCreator.create(type, context);
        //添加avloadingview作为dialog视图
        dialog.setContentView(avLoadingIndicatorView);
        //控制dialog宽高
        int deviceWidth = DimenUtil.getScreenWidth();
        int deviceHeight = DimenUtil.getScreenHeight();
        //创建dialog window对象
        final Window dialogWindow = dialog.getWindow();
        if (dialogWindow != null) {
            WindowManager.LayoutParams lp = dialogWindow.getAttributes();
            lp.width = deviceWidth / LOADER_SIZE_SCALE;
            lp.height = deviceHeight / LOADER_SIZE_SCALE;
            lp.height = lp.height + deviceHeight / LOADER_OFFSET_SCALE;
            lp.gravity = Gravity.CENTER;
        }
        //加入dialog管理
        LOADERS.add(dialog);
        dialog.show();
    }

    public static void showLoading(Context context,Enum<LoaderStyle> type){
        showLoading(context,type.name());
    }

    /**
     * 重载的显示对话框方法
     *
     * @param context
     */
    public static void showLoading(Context context) {
        showLoading(context, DEFAULT_LOADER);
    }

    /**
     * 停止显示对话框方法
     */
    public static void stopLoading() {
        for (AppCompatDialog dialog : LOADERS) {
            if (dialog != null) {
                dialog.cancel();
            }
        }
    }

}
