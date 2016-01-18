package com.yijiet.client.entity.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/18 0018.
 */
public class BaseListEntity<T> {
    /**
     * datas : 8604
     * code : 200
     * msg : 短信验证码发送成功
     */

    private List<T> datas = new ArrayList<>();
    private int code;
    private String msg;

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getDatas() {
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
        return "BaseListEntity{" +
                "datas='" + datas + '\'' +
                ", code='" + code + '\'' +
                ", msg=" + msg +
                '}';
    }
}
