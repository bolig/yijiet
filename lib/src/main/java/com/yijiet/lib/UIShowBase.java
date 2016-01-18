package com.yijiet.lib;

import android.view.View;

/**
 * author:libo
 * time:2015/9/6
 * E-mail:boli_android@163.com
 * last: ...
 */
public interface UIShowBase {
    /**
     * 显示错误界面
     *
     * @return
     */
    View showErrorLayout();

    /**
     * 展示数据加载界面
     *
     * @return
     */
    View showLoadingLayout();

    /**
     * 显示数据为空的界面
     *
     * @return
     */
    View showNoDataLayout();

}
