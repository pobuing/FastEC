package com.probuing.latte_core.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ContentFrameLayout;

import com.probuing.latte_core.R;
import com.probuing.latte_core.delegates.LatteDelegate;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * @author wxblack-mac
 * @DATE 2018/10/15 16:06
 * @DESCRIBE: 1 Activity 多 fragment 的容器Activity
 * GOOD LUCK
 */
public abstract class ProxyActivity extends SupportActivity {
    /**
     * 设置根delegate
     *
     * @return
     */
    public abstract LatteDelegate setRootDelegate();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContainer(savedInstanceState);
    }

    /**
     * 初始化容器布局
     *
     * @param savedInstanceState
     */
    private void initContainer(@Nullable Bundle savedInstanceState) {
        //创建存放fragment的容器
        @SuppressLint("RestrictedApi") final ContentFrameLayout frameLayout = new ContentFrameLayout(this);
        frameLayout.setId(R.id.delegate_container);
        setContentView(frameLayout);
        //并未存储过状态
        if (savedInstanceState == null) {
            loadRootFragment(R.id.delegate_container, setRootDelegate());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //垃圾回收
        System.gc();
        System.runFinalization();
    }
}
