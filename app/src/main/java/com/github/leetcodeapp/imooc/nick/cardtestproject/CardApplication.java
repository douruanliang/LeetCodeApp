package com.github.leetcodeapp.imooc.nick.cardtestproject;

import android.app.Application;
import android.content.Context;

import com.github.leetcodeapp.http.Util.CrashHandler;
import com.github.leetcodeapp.http.api.OkHttpUtil;
import com.github.leetcodeapp.imooc.nick.cardtestproject.db.QuestionDaoOpenHelper;


public class CardApplication extends Application {

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        OkHttpUtil.init();
        mContext = this;
        QuestionDaoOpenHelper.initDatabase();
        CrashHandler.getInstance().init(this);
    }


}
