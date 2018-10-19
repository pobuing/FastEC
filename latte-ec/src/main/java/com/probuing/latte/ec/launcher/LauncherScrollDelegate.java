package com.probuing.latte.ec.launcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.probuing.latte.ec.R;
import com.probuing.latte_core.delegates.LatteDelegate;
import com.probuing.latte_core.ui.launcher.LauncherHolderCreator;
import com.probuing.latte_core.ui.launcher.ScollLauncherTag;
import com.probuing.latte_core.util.storage.LattePreference;

import java.util.ArrayList;

/**
 * @author wxblack-mac
 * @DATE 2018/10/19 15:51
 * @DESCRIBE: 轮播启动页
 * GOOD LUCK
 */
public class LauncherScrollDelegate extends LatteDelegate implements OnItemClickListener {
    private ConvenientBanner<Integer> mConvenientBanner = null;
    private static final ArrayList<Integer> INTEGERS = new ArrayList<>();

    private void initBanner() {
        INTEGERS.add(R.mipmap.launcher_01);
        INTEGERS.add(R.mipmap.launcher_02);
        INTEGERS.add(R.mipmap.launcher_03);
        INTEGERS.add(R.mipmap.launcher_04);
        INTEGERS.add(R.mipmap.launcher_05);
        mConvenientBanner
                .setPages(new LauncherHolderCreator(), INTEGERS)
                .setPageIndicator(new int[]{R.drawable.dot_normal, R.drawable.dot_focus})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setOnItemClickListener(this)
                .setCanLoop(false);


    }

    @Override
    public Object setLayout() {
        mConvenientBanner = new ConvenientBanner<Integer>(getContext());
        return mConvenientBanner;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @Nullable View rootView) {
        initBanner();
    }

    @Override
    public void onItemClick(int position) {
        //判断是否是最后一个
        if (position == INTEGERS.size() - 1) {
            LattePreference.setAppFlag(ScollLauncherTag.HAS_FIRST_LAUNCHER_APP.name(), true);
            //判断用户是否登录
        }
    }
}
