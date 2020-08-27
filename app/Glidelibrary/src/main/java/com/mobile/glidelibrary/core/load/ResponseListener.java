package com.mobile.glidelibrary.core.load;

import com.mobile.glidelibrary.resource.Value;

/**
 * @author: douruanliang
 * @date: 2020/8/27
 */
public interface ResponseListener {
    void responseSuccess(Value value);
    void responseException(Exception e);
}
