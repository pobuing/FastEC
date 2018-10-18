package com.probuing.latte_core.net.download;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;

import com.probuing.latte_core.app.Latte;
import com.probuing.latte_core.net.callback.IRequest;
import com.probuing.latte_core.net.callback.ISuccess;
import com.probuing.latte_core.util.file.FileUtil;

import java.io.File;
import java.io.InputStream;

import okhttp3.ResponseBody;

/**
 * @author wxblack-mac
 * @DATE 2018/10/18 14:51
 * @DESCRIBE: ${?}
 * GOOD LUCK
 */
public class SaveFileTask extends AsyncTask<Object, Void, File> {
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;

    public SaveFileTask(IRequest request, ISuccess success) {
        this.REQUEST = request;
        this.SUCCESS = success;
    }

    @Override
    protected File doInBackground(Object... params) {
        String downloadDir = (String) params[0];
        String extension = (String) params[1];
        ResponseBody responseBody = (ResponseBody) params[2];
        String name = (String) params[3];
        InputStream is = responseBody.byteStream();
        if (TextUtils.isEmpty(downloadDir)) {
            downloadDir = "down_loads";
        }

        if (TextUtils.isEmpty(extension)) {
            extension = "";
        }
        if (TextUtils.isEmpty(name)) {
            return FileUtil.writeToDisk(is, downloadDir, extension.toUpperCase(), extension);
        } else {
            return FileUtil.writeToDisk(is, downloadDir, name);
        }
    }

    @Override
    protected void onPostExecute(File file) {
        super.onPostExecute(file);
        if (SUCCESS != null) {
            SUCCESS.onSuccess(file.getPath());
        }

        if (REQUEST != null) {
            REQUEST.onRequestEnd();
        }

    }


    /**
     * 自动安装apk
     *
     * @param file 文件对象
     */
    private void autoInstallApk(File file) {
        //判断下载的文件是否是apk文件
        if (FileUtil.getExtension(file.getPath()).equals("apk")) {
            Intent install = new Intent();
            //创建新栈
            install.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            install.setAction(Intent.ACTION_VIEW);
            install.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            Latte.getApplicationContext().startActivity(install);
        }
    }
}
