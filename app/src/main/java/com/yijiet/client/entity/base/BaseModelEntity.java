package com.yijiet.client.entity.base;

/**
 * Created by Administrator on 2016/1/18 0018.
 */
public class BaseModelEntity<T> {
    /**
     * datas : 8604
     * code : 200
     * msg : 短信验证码发送成功
     */

    private T datas;
    private int code;
    private String msg;

    public void setDatas(T datas) {
        this.datas = datas;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getDatas() {
        return datas;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "BaseModelEntity{" +
                "datas=" + datas +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
