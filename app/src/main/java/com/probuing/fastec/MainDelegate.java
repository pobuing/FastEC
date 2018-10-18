package com.probuing.fastec;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.probuing.latte_core.delegates.LatteDelegate;
import com.probuing.latte_core.net.RestClient;
import com.probuing.latte_core.net.callback.IError;
import com.probuing.latte_core.net.callback.IFailure;
import com.probuing.latte_core.net.callback.ISuccess;

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
        testRestClient();
    }

    private void testRestClient() {
        RestClient.builder().url("http://news.baidu.com/")
                .loader(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                    }
                }).failure(new IFailure() {
            @Override
            public void onFailure() {

            }
        }).error(new IError() {
            @Override
            public void onError(int code, String msg) {

            }
        }).build().get();
    }
}
