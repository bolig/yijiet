package com.yijiet.lib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * author:libo
 * time:2015/9/11
 * E-mail:boli_android@163.com
 * last: ...
 */
public class NoSrcollListView extends ListView {

    public NoSrcollListView(Context context) {
        super(context);
    }

    public NoSrcollListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoSrcollListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
