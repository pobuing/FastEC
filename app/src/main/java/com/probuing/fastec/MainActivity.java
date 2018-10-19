package com.probuing.fastec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;

import com.probuing.latte.ec.launcher.LauncherDelegate;
import com.probuing.latte.ec.launcher.LauncherScrollDelegate;
import com.probuing.latte.ec.sign.SignUpDelegate;
import com.probuing.latte_core.activities.ProxyActivity;
import com.probuing.latte_core.delegates.LatteDelegate;

public class MainActivity extends ProxyActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    @Override
    public LatteDelegate setRootDelegate() {
        return new SignUpDelegate();
    }

}
