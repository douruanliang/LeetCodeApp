package com.github.leetcodeapp.login;

import android.widget.Toast;

import com.github.leetcodeapp.base.BaseModel;
import com.github.leetcodeapp.bean.UserInfo;

/**
 * @author: douruanliang
 * @date: 2020/8/22
 */
public class LoginModel extends BaseModel<LoginPresenter,LoginContract.Model> {
    public LoginModel(LoginPresenter loginPresenter) {
        super(loginPresenter);
    }

    @Override
    public LoginContract.Model getContract() {
        return new LoginContract.Model() {
            @Override
            public void executeLogin(String name, String pwd) throws Exception {
                if ("123".equalsIgnoreCase(name)){
                    p.getContract().responseResult(new UserInfo(name,pwd));
                }else{
                    p.getContract().responseResult(null);
                }
            }
        };
    }
}
