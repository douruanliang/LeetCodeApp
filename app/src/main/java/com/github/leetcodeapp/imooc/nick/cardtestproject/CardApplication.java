package com.github.leetcodeapp.imooc.nick.cardtestproject;

import android.app.Application;
import android.content.Context;
import android.os.Debug;

import androidx.core.os.TraceCompat;

import com.github.leetcodeapp.http.Util.CrashHandler;
import com.github.leetcodeapp.http.api.OkHttpUtil;
import com.github.leetcodeapp.imooc.nick.cardtestproject.db.QuestionDaoOpenHelper;


public class CardApplication extends Application {

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        //Debug.startMethodTracing("appTrace");

        TraceCompat.beginSection("appOnCreate");
        OkHttpUtil.init();
        mContext = this;
        QuestionDaoOpenHelper.initDatabase();
        CrashHandler.getInstance().init(this);
       // Debug.stopMethodTracing();
        TraceCompat.endSection();
    }



}
