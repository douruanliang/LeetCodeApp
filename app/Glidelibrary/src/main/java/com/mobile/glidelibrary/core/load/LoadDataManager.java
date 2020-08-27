package com.mobile.glidelibrary.core.load;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.mobile.glidelibrary.resource.Value;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * @author: douruanliang
 * @date: 2020/8/27
 */
public class LoadDataManager implements ILoadData, Runnable {

    private static final String TAG = LoadDataManager.class.getSimpleName();
    private String path;
    private ResponseListener listener;
    private Context context;

    @Override
    public Value loadResource(String path, ResponseListener listener, Context context) {
        this.context = context;
        this.listener = listener;
        this.path = path;
        // 加载网络
        Uri uri = Uri.parse(path);
        if ("HTTP".equalsIgnoreCase(uri.getScheme())
                || "HTTPS".equalsIgnoreCase(uri.getScheme())) {
            new ThreadPoolExecutor(
                    0, Integer.MAX_VALUE,
                    60, TimeUnit.SECONDS,
                    new SynchronousQueue<Runnable>()
            ).execute(this);
        }
        // 加载SD
        return null;
    }

    @Override
    public void run() {
        InputStream stream = null;
        HttpURLConnection connection = null;
        try {
            URL url = new URL(path);
            connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            final int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                stream = connection.getInputStream();
                final Bitmap bitmap = BitmapFactory.decodeStream(stream);

                new Handler(Looper.getMainLooper())
                        .post(new Runnable() {
                                  @Override
                                  public void run() {
                                      Value value = Value.getInstance();
                                      value.setBitmap(bitmap);

                                      if (listener != null) {
                                          listener.responseSuccess(value);
                                      }
                                  }
                              }
                        );
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        if (listener != null) {
                            listener.responseException(new IllegalStateException("请求失败，请求码" + responseCode));
                        }
                    }
                });
            }

        } catch (final Exception e) {
            e.printStackTrace();
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    if (listener != null) {
                        listener.responseException(e);
                    }
                }
            });
        }finally {
            if (stream!=null){
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.d(TAG,"run 关闭 stream");
                }
            }

            if (connection!=null){
                connection.disconnect();
            }
        }
    }
}
