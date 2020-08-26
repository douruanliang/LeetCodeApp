package com.mobile.glidelibrary.core;

/**
 * @author: douruanliang
 * @date: 2020/8/26
 */
class GlideBuilder {
    public Glide build() {
        RequestManagerRetriver retriver = new RequestManagerRetriver();
        Glide glide = new Glide(retriver);
        return glide;
    }
}
