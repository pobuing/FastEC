package com.probuing.latte_core.net.callback;

/**
 * @author wxblack-mac
 * @DATE 2018/10/16 14:33
 * @DESCRIBE: 请求状态回调
 * GOOD LUCK
 */
public interface IRequest {
    void onRequestStart();
    void onRequestEnd();
}
