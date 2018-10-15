package com.probuing.latte_core.delegates;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * @author wxblack-mac
 * @DATE 2018/10/15 16:07
 * @DESCRIBE: 基础Delegate
 * GOOD LUCK
 */
@SuppressWarnings("ALL")
public abstract class BaseDelegate extends SwipeBackFragment {
    //设置布局
    public abstract Object setLayout();

    private Unbinder mUnbinder = null;

    /**
     * 绑定视图
     *
     * @param savedInstanceState
     * @param rootView
     */
    public abstract void onBindView(@Nullable Bundle savedInstanceState, @Nullable View rootView);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = null;
        // TODO: 2018/10/15 判断是否是id布局
        if (setLayout() instanceof Integer) {
            root = inflater.inflate((Integer) setLayout(), container, false);
        } else if (setLayout() instanceof View) {
            root = (View) setLayout();
        }
        if (root != null) {
            mUnbinder = ButterKnife.bind(this, root);
            onBindView(savedInstanceState, root);
        }
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //解除绑定
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }
}
