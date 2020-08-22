package com.github.leetcodeapp.login;

import com.github.leetcodeapp.base.BasePresenter;
import com.github.leetcodeapp.bean.UserInfo;

/**
 * @author: douruanliang
 * @date: 2020/8/22
 */
public class LoginPresenter extends BasePresenter<LoginActivity,LoginModel,LoginContract.Presenter> {
    @Override
    public LoginContract.Presenter getContract() {
        return new LoginContract.Presenter<UserInfo>(){
            @Override
            public void requestLogin(String name, String pwd) throws Exception {

                //三种封装 转发 、M 、自己干
                m.getContract().executeLogin(name,pwd);
            }

            @Override
            public void responseResult(UserInfo userInfo) {
                getView().getConTract().handlerResult(userInfo);
            }
        };
    }

    @Override
    public LoginModel getM() {
        return new LoginModel(this);
    }
}
