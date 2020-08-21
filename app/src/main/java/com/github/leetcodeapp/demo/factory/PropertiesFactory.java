package com.github.leetcodeapp.demo.factory;

import android.content.Context;

import com.github.leetcodeapp.demo.Api;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author: douruanliang
 * @date: 2020/8/21
 */
public class PropertiesFactory {

    public static Api create(Context context) {

        Properties properties = new Properties();

        try {
            InputStream inputStream = context.getAssets().open("config.properties");
            properties.load(inputStream);

            Class clazz = Class.forName(properties.getProperty("create_a"));

            return (Api) clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
