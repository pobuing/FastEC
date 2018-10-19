package com.probuing.latte.ec.launcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.probuing.latte.ec.R;
import com.probuing.latte.ec.R2;
import com.probuing.latte_core.delegates.LatteDelegate;
import com.probuing.latte_core.ui.launcher.ScollLauncherTag;
import com.probuing.latte_core.util.storage.LattePreference;
import com.probuing.latte_core.util.timer.BaseTimerTask;
import com.probuing.latte_core.util.timer.ITimerListener;

import java.text.MessageFormat;
import java.util.Timer;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author wxblack-mac
 * @DATE 2018/10/19 14:56
 * @DESCRIBE: 启动页
 * GOOD LUCK
 */
public class LauncherDelegate extends LatteDelegate implements ITimerListener {
    @BindView(R2.id.tv_launcher_timer)
    AppCompatTextView mTvTimer = null;
    private int mCount = 5;
    private Timer mTimer = null;

    @Override
    public Object setLayout() {
        return R.layout.delegate_launcher;
    }

    /**
     * 跳过按钮点击
     */
    @OnClick(R2.id.tv_launcher_timer)
    void onClickTimerView() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
            checkIsShwoScroll();
        }
    }

    /**
     * 初始化Timer
     */
    private void initTimer() {
        mTimer = new Timer();
        final BaseTimerTask task = new BaseTimerTask(this);
        mTimer.schedule(task, 0, 1000);
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @Nullable View rootView) {
        initTimer();
    }

    private void checkIsShwoScroll() {
        //是第一次启动
        if (!LattePreference.getAppFlag(ScollLauncherTag.HAS_FIRST_LAUNCHER_APP.name())) {
            start(new LauncherScrollDelegate(), SINGLETASK);
        } else {
            //检查用户是否登录app
        }
    }

    @Override
    public void onTimer() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mTimer != null) {
                    mTvTimer.setText(MessageFormat.format("跳过\n{0}s", mCount));
                    mCount--;
                    if (mCount < 0) {
                        if (mTimer != null) {
                            mTimer.cancel();
                            mTimer = null;
                            checkIsShwoScroll();
                        }
                    }
                }
            }
        });
    }
}
