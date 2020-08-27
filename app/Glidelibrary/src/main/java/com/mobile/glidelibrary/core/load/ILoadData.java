package com.mobile.glidelibrary.core.load;

import android.content.Context;

import com.mobile.glidelibrary.resource.Value;

/**
 * 记载外部资源
 * @author: douruanliang
 * @date: 2020/8/27
 */


public interface ILoadData {

    Value loadResource(String path,
                       ResponseListener listener,
                       Context context);
}
