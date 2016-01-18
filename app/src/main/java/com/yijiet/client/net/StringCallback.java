package com.yijiet.client.net;

import android.text.TextUtils;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Administrator on 2016/1/18 0018.
 */
public abstract class StringCallback extends BaseCallBack {

    @Override
    public void onSuccess(int statusCode, Header[] headers, String response) {
        if (TextUtils.isEmpty(response)) {
            onResponseFailure(ERROR, "数据异常");
        } else {
            onCallback(response);
        }
    }

    public abstract void onCallback(String response);
}
