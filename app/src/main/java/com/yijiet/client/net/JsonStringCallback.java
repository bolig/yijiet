package com.yijiet.client.net;

import android.text.TextUtils;

import com.yijiet.client.entity.base.BaseJsonEntity;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Administrator on 2016/1/18 0018.
 */
public abstract class JsonStringCallback extends BaseCallBack {

    @Override
    public final void onSuccess(int statusCode, Header[] headers, String response) {
        if (TextUtils.isEmpty(response)) {
            onResponseFailure(ERROR, "数据异常");
        } else {
            BaseJsonEntity resp = getGson().fromJson(response, BaseJsonEntity.class);
            if (resp.getCode() == 200) {
                onCallback(resp.getDatas());
            } else {
                onResponseFailure(resp.getCode(), resp.getMsg());
            }
        }
    }

    public abstract void onCallback(String response);
}
