package com.yijiet.client.net;

import com.loopj.android.http.RequestParams;
import com.yijiet.lib.ActivityBase;

/**
 * Created by Administrator on 2016/1/18 0018.
 */
public class BaseServer {

    protected final ActivityBase mActBase;

    public BaseServer(ActivityBase base) {
        this.mActBase = base;
    }

    /**
     * 请求成功将返回所以数据的字符串
     *
     * @param url
     * @param params
     * @param callback
     */
    public void requestString(String url, RequestParams params, StringCallback callback) {
        if (callback == null)
            return;
        AsyncHttpUtil.post(url, params, callback);
    }

    /**
     * 请求成功将返回解析后的字符串
     *
     * @param url
     * @param params
     * @param callback
     */
    public void requestJsonString(String url, RequestParams params, JsonStringCallback callback) {
        if (callback == null)
            return;
        AsyncHttpUtil.post(url, params, callback);
    }

    /**
     * 成功将返回解析后的实体
     *
     * @param url
     * @param params
     * @param clazz
     * @param callback
     * @param <T>
     */
    public <T> void requestModel(String url, RequestParams params, Class<T> clazz, ModelCallback<T> callback) {
        if (callback == null)
            return;
        callback.setClazz(clazz);
        AsyncHttpUtil.post(url, params, callback);
    }

    /**
     * 成功将返回解析后的实体集合
     *
     * @param url
     * @param params
     * @param clazz
     * @param callback
     * @param <T>
     */
    public <T> void requestList(String url, RequestParams params, Class<T> clazz, ListCallback<T> callback){
        if (callback == null)
            return;
        callback.setClazz(clazz);
        AsyncHttpUtil.post(url, params, callback);
    }
}
