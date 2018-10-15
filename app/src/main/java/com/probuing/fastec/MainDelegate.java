package com.probuing.fastec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.probuing.latte_core.delegates.LatteDelegate;

/**
 * @author wxblack-mac
 * @DATE 2018/10/15 17:51
 * @DESCRIBE: ${?}
 * GOOD LUCK
 */
public class MainDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_main;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @Nullable View rootView) {

    }
}
