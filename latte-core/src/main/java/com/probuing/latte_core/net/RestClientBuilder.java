package com.probuing.latte_core.net;

import android.content.Context;

import com.probuing.latte_core.net.callback.IError;
import com.probuing.latte_core.net.callback.IFailure;
import com.probuing.latte_core.net.callback.IRequest;
import com.probuing.latte_core.net.callback.ISuccess;
import com.probuing.latte_core.ui.LoaderStyle;

import java.io.File;
import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * @author wxblack-mac
 * @DATE 2018/10/16 14:29
 * @DESCRIBE: RestClientBuilder每次再构建的时候都是一个全新的实例 中间不允许更改
 * GOOD LUCK
 */
public class RestClientBuilder {
    private String mUrl = null;
    private static final Map<String, Object> mParams = RestCreator.getParams();
    private IRequest mIRequest = null;
    private ISuccess mISuccess = null;
    private IFailure mIFailure = null;
    private IError mIError = null;
    private RequestBody mBody = null;
    private File mFile = null;
    private Context mContext = null;
    private LoaderStyle mloaderStyle = null;


    private static final class ParamsHolder {
        public static final WeakHashMap<String, Object> PARAMS = new WeakHashMap<>();
    }


    RestClientBuilder() {

    }

    public final RestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    public final RestClientBuilder params(WeakHashMap<String, Object> params) {
        mParams.putAll(params);
        return this;
    }

    public final RestClientBuilder params(String key, Object value) {
        mParams.put(key, value);
        return this;
    }

    public final RestClientBuilder onRequest(IRequest iRequest) {
        this.mIRequest = iRequest;
        return this;
    }

    public final RestClientBuilder file(String filePath) {
        mFile = new File(filePath);
        return this;
    }

    public final RestClientBuilder file(File file) {
        mFile = file;
        return this;
    }

    public final RestClientBuilder raw(String raw) {
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    public final RestClientBuilder success(ISuccess iSuccess) {
        this.mISuccess = iSuccess;
        return this;
    }

    public final RestClientBuilder failure(IFailure iFailure) {
        this.mIFailure = iFailure;
        return this;
    }

    public final RestClientBuilder error(IError iError) {
        this.mIError = iError;
        return this;
    }

    public final RestClientBuilder loader(Context context, LoaderStyle style) {
        this.mContext = context;
        this.mloaderStyle = style;
        return this;
    }

    /**
     * 默认的loader
     *
     * @param context 上下文
     * @return
     */
    public final RestClientBuilder loader(Context context) {
        this.mContext = context;
        this.mloaderStyle = LoaderStyle.BallClipRotatePulseIndicator;
        return this;
    }

    public final RestClient build() {
        return new RestClient(mUrl,
                mParams,
                mIRequest,
                mISuccess,
                mIFailure,
                mIError,
                mBody,
                mFile,
                mContext,
                mloaderStyle);
    }

}
