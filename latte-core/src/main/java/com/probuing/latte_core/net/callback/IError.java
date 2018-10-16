package com.probuing.latte_core.net.callback;

/**
 * @author wxblack-mac
 * @DATE 2018/10/16 14:32
 * @DESCRIBE: 请求失败后的回调
 * GOOD LUCK
 */
public interface IError {
    void onError(int code, String msg);
}
