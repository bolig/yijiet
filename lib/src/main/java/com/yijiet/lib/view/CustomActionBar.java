package com.yijiet.lib.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yijiet.lib.R;


/**
 * author:libo
 * time:2015/9/28
 * E-mail:boli_android@163.com
 * last: ...
 */
public class CustomActionBar extends RelativeLayout {
    private ImageView ivL;
    private TextView tvTitle;
    private TextView tvR;
    private ImageView ivR;
    private View rootView;

    private void assignViews() {
        ivL = (ImageView) rootView.findViewById(R.id.iv_l);
        tvTitle = (TextView) rootView.findViewById(R.id.tv_title);
        tvR = (TextView) rootView.findViewById(R.id.tv_r);
        ivR = (ImageView) rootView.findViewById(R.id.iv_r);
    }


    public CustomActionBar(Context context) {
        super(context);
        init();
    }

    public CustomActionBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomActionBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        if (isInEditMode()) {
            return;
        }
        rootView = LayoutInflater.from(getContext()).inflate(R.layout.layout_action_abr, null);
        assignViews();
        addView(rootView);

        tvTitle.setVisibility(GONE);
        tvR.setVisibility(GONE);

        rootView.post(new Runnable() {
            @Override
            public void run() {
                LayoutParams params = (LayoutParams) rootView.getLayoutParams();
                params.height = getResources().getDimensionPixelSize(R.dimen.action_height);
                params.width = LayoutParams.MATCH_PARENT;
                rootView.setLayoutParams(params);
            }
        });
    }

    public CustomActionBar setBack() {
        ivL.setImageResource(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        ivL.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ((Activity) getContext()).finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        return this;
    }

    /**
     * 设置左边ImageView的属性
     *
     * @param resId
     * @param listener
     */
    public CustomActionBar setIvL(int resId, OnClickListener listener) {
        ivL.setImageResource(resId);
        ivL.setOnClickListener(listener);
        return this;
    }

    /**
     * 设置标题
     *
     * @param title
     */
    public CustomActionBar setTvTitle(String title) {
        tvTitle.setText(title);
        tvTitle.setVisibility(VISIBLE);
        return this;
    }

    /**
     * 设置右边文本控件文字和单击事件
     *
     * @param rTvText
     * @param listener
     */
    public CustomActionBar setTvR(String rTvText, OnClickListener listener) {
        tvR.setText(rTvText);
        tvR.setOnClickListener(listener);
        tvR.setVisibility(VISIBLE);
        return this;
    }

    /**
     * 设置右边控件图片与单击事件
     *
     * @param resId
     * @param listener
     * @return
     */
    public CustomActionBar setIvR(int resId, OnClickListener listener) {
        ivR.setImageResource(resId);
        ivR.setOnClickListener(listener);
        tvR.setVisibility(GONE);
        return this;
    }

    /**
     * dp转换为px
     *
     * @param dpValue
     * @return
     */
    public int dip2px(float dpValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        //MyLogger.i(scale+"");
        return (int) (dpValue * scale + 0.5f);
    }

    public CustomActionBar showSearch(boolean isShow, OnClickListener listener) {
        return this;
    }

    public CustomActionBar showR2(OnClickListener listener) {
        return this;
    }
}
