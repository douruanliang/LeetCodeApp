package com.github.leetcodeapp.login;

import com.github.leetcodeapp.bean.BaseEntity;

/**
 * @author: douruanliang
 * @date: 2020/8/21
 * 将 Model view Present层协商的共同业务，封装成接口
 */
public interface LoginContract {

    // P - > M
    interface Model{
        void executeLogin(String name,String pwd)throws Exception;
    }

    // P - > V
    interface View<T extends BaseEntity>{
        void handlerResult(T t);
    }

    interface Presenter<T extends BaseEntity>{

        // v -> p
        void requestLogin(String name,String pwd) throws Exception;

        void responseResult(T t);
    }
}
