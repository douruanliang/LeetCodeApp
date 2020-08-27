package com.github.httpslibrary;

/**
 * @author: douruanliang
 * @date: 2020/8/26
 */
public class Request {
    private String url;

    public Request() {
        this(new Builder());
    }

    public Request(Builder builder) {
        if (builder != null) {
            this.url = builder.url;
        }
    }

    public final static class Builder {
        private String url;

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        
    }
}