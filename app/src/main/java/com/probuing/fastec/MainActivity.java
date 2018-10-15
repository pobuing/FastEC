package com.probuing.fastec;

import com.probuing.latte_core.activities.ProxyActivity;
import com.probuing.latte_core.delegates.LatteDelegate;

public class MainActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new MainDelegate();
    }

}
