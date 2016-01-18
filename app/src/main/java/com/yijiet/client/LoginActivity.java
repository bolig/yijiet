package com.yijiet.client;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yijiet.lib.base.BaseActivity;

/**
 * 登录界面
 */
public class LoginActivity extends BaseActivity {

    private LinearLayout llLogin;
    private EditText etUser;
    private EditText etPass;
    private TextView tvLogin;
    private TextView tvMore;
    private TextView tvFind;
    private TextView tvRegistor;
    private LinearLayout llRegistor;
    private EditText etPhone;
    private EditText etCode;
    private TextView tvGetCode;
    private EditText etRegistorPass;
    private TextView tvToRegistor;

    private void assignViews() {
        llLogin = (LinearLayout) findViewById(R.id.ll_login);
        etUser = (EditText) findViewById(R.id.et_user);
        etPass = (EditText) findViewById(R.id.et_pass);
        tvLogin = (TextView) findViewById(R.id.tv_login);
        tvMore = (TextView) findViewById(R.id.tv_more);
        tvFind = (TextView) findViewById(R.id.tv_find);
        tvRegistor = (TextView) findViewById(R.id.tv_registor);
        llRegistor = (LinearLayout) findViewById(R.id.ll_registor);
        etPhone = (EditText) findViewById(R.id.et_phone);
        etCode = (EditText) findViewById(R.id.et_code);
        tvGetCode = (TextView) findViewById(R.id.tv_getCode);
        etRegistorPass = (EditText) findViewById(R.id.et_registor_pass);
        tvToRegistor = (TextView) findViewById(R.id.tv_toRegistor);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.act_login);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        assignViews();
    }

    @Override
    public void initListener() {

    }
}
