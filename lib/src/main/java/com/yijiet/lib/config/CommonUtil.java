package com.yijiet.lib.config;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;

import com.yijiet.lib.util.ShareUserHelper;


/**
 * author:libo
 * time:2015/7/9
 * E-mail:boli_android@163.com
 * last: ...
 */
public class CommonUtil {
    private static DisplayMetrics metrics;

    public static Context mContext;
    public static int w_screeen;
    public static int h_screeen;

    public static ShareUserHelper mShareHelper;

    /**
     * 配置全局Context
     *
     * @param context
     */
    public static void initContext(@NonNull Context context) {
        mContext = context;
        metrics = context.getResources().getDisplayMetrics();

        mShareHelper = ShareUserHelper.getInstance(context);

        w_screeen = metrics.widthPixels;
        h_screeen = metrics.heightPixels;
    }

    /**
     * dp转换为px
     *
     * @param dpValue
     * @return
     */
    public static int dip2px(float dpValue) {
        final float scale = mContext.getResources().getDisplayMetrics().density;
        //MyLogger.i(scale+"");
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * px装换成dp
     */
    public static int px2dip(float pxValue) {
        final float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * sp转换为px
     */
    public static int sp2px(float spValue) {
        final float scale = mContext.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * scale + 0.5f);
    }

    /**
     * px转换为sp
     */
    public static int px2sp(float pxValue) {
        final float scale = mContext.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / scale + 0.5f);
    }
}
