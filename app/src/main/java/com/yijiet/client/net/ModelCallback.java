package com.yijiet.client.net;

import com.yijiet.client.entity.base.BaseModelEntity;

import java.lang.reflect.Type;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Administrator on 2016/1/18 0018.
 */
public abstract class ModelCallback<T> extends BaseCallBack<T> {

    @Override
    public void onSuccess(int statusCode, Header[] headers, String response) {
        if (getClazz() == null)
            throw new NullPointerException(" @libo Clazz is null ");
        Type type = getType(BaseModelEntity.class, getClazz());
        BaseModelEntity<T> resp = getGson().fromJson(response, type);
        if (resp.getCode() == 200) {
            onCallback(resp.getDatas());
        } else {
            onResponseFailure(resp.getCode(), resp.getMsg());
        }
    }

    public abstract void onCallback(T response);
}
