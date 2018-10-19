package com.probuing.latte_core.ui.launcher;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;

import com.bigkoo.convenientbanner.holder.Holder;

/**
 * @author wxblack-mac
 * @DATE 2018/10/19 16:32
 * @DESCRIBE: ${?}
 * GOOD LUCK
 */
public class LauncherHolder implements Holder<Integer> {
    private AppCompatImageView mImageView = null;

    @Override
    public View createView(Context context) {
        mImageView = new AppCompatImageView(context);
        return mImageView;
    }

    @Override
    public void UpdateUI(Context context, int position, Integer data) {
        mImageView.setBackgroundResource(data);
    }
}
