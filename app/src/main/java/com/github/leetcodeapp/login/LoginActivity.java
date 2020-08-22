package com.github.leetcodeapp.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.leetcodeapp.R;
import com.github.leetcodeapp.base.BaseView;
import com.github.leetcodeapp.bean.BaseEntity;
import com.github.leetcodeapp.bean.UserInfo;

public class LoginActivity extends BaseView<LoginPresenter,LoginContract.View> {

    EditText nameEt;
    EditText pwdEt;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    // 初始化控件
    private void initView() {
        nameEt = findViewById(R.id.et_name);
        pwdEt = findViewById(R.id.et_pwd);
        btn = findViewById(R.id.bt_login);
    }

    @Override
    public LoginContract.View getConTract() {
        return new LoginContract.View<UserInfo>(){
            @Override
            public void handlerResult(UserInfo userInfo) {
                if (userInfo != null) {
                    Toast.makeText(LoginActivity.this, userInfo.toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "登录失败！", Toast.LENGTH_SHORT).show();
                }
            }
        };

    }

    @Override
    public LoginPresenter getPresenter() {
        return new LoginPresenter();
    }

    public void doLoginAction(View view) {

        String name = nameEt.getText().toString();
        String pwd = pwdEt.getText().toString();

        try {
            p.getContract().requestLogin(name,pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}