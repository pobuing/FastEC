package com.probuing.latte_core.util.timer;

import java.util.TimerTask;

/**
 * @author wxblack-mac
 * @DATE 2018/10/19 14:57
 * @DESCRIBE: 基础Timer Task
 * GOOD LUCK
 */
public class BaseTimerTask extends TimerTask {
    private ITimerListener mITimerListener;

    public BaseTimerTask(ITimerListener mITimerListener) {
        this.mITimerListener = mITimerListener;
    }

    @Override
    public void run() {
        if (mITimerListener != null) {
            mITimerListener.onTimer();
        }
    }
}
