package com.yijiet.client.net;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.yijiet.lib.util.MyLogger;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import cz.msebera.android.httpclient.Header;

/**
 * 数据请求数据返回操作类
 * <p/>
 * author:libo
 * time:2015/9/23
 * E-mail:boli_android@163.com
 * last: ...
 */
public abstract class BaseCallBack<T> extends AsyncHttpResponseHandler {

    private static String LOG_TAG = " baseCallback ";
    public static final int ERROR = 0;

    private Class<T> mClazz;
    private Gson mGson;

    public Gson getGson() {
        if (mGson == null){
            mGson = new Gson();
        }
        return mGson;
    }

    public void setmGson(Gson mGson) {
        this.mGson = mGson;
    }

    public void setClazz(Class<T> mClazz) {
        this.mClazz = mClazz;
    }

    public Class<T> getClazz() {
        return mClazz;
    }

    @Override
    public final void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
        String response = getResponseString(responseBody, getCharset());
        MyLogger.e(" response = " + response);
        onSuccess(statusCode, headers, response);
    }

    @Override
    public final void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
        onFailure(statusCode, headers, getResponseString(responseBody, getCharset()), error);
    }

    /**
     * 自定义错误处理
     *
     * @param statusCode
     * @param headers
     * @param responseString
     * @param throwable
     */
    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
        MyLogger.e(" statusCode = " + statusCode);
        MyLogger.e(responseString);
        onResponseFailure(statusCode, "网络连接异常, 请稍后再试");
    }

    /**
     * 自定义错误回调
     *
     * @param statusCode
     * @param msg
     */
    protected abstract void onResponseFailure(int statusCode, String msg);

    /**
     * 请求成功的回调
     *
     * @param statusCode http response status line
     * @param headers    response headers if any
     * @param response   string response of given charset
     */
    public abstract void onSuccess(int statusCode, Header[] headers, String response);

    /**
     * 获取数据解析类型
     *
     * @param mBaseClass
     * @param mClazz
     * @return
     */
    protected Type getType(final Class<?> mBaseClass, final Class... mClazz) {
        return new ParameterizedType() {
            public Type getRawType() {
                return mBaseClass;
            }

            public Type[] getActualTypeArguments() {
                return mClazz;
            }

            public Type getOwnerType() {
                return null;
            }
        };
    }

    /**
     * 将返回的字节数组转换成String
     *
     * @param stringBytes
     * @param charset
     * @return
     */
    private String getResponseString(byte[] stringBytes, String charset) {
        try {
            String toReturn = (stringBytes == null) ? null : new String(stringBytes, charset);
            if (toReturn != null && toReturn.startsWith(UTF8_BOM)) {
                return toReturn.substring(1);
            }
            MyLogger.e(" --- response string --- " + toReturn);
            return toReturn;
        } catch (UnsupportedEncodingException e) {
            AsyncHttpClient.log.e(LOG_TAG, "Encoding response into string failed", e);
            return "";
        }
    }

}
