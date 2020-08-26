package com.mobile.glidelibrary.cache.disk;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import com.mobile.glidelibrary.resource.Value;
import com.mobile.glidelibrary.utils.Tool;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author: douruanliang
 * @date: 2020/8/26
 */
public class DiskLruCacheImpl {

    private final String DISK_CACHE_DIR = "disk_cache_dir";
    private final int APP_VERSION = 999;
    private final int VALUE_COUNT = 1;
    private final long MAX_SIZE = 1024 * 1024 * 10;

    private DiskLruCache diskLruCache;
    private static final String TAG = DiskLruCacheImpl.class.getSimpleName();

    public DiskLruCacheImpl() {
        File file = new File(Environment.getExternalStorageDirectory()
                + File.separator + DISK_CACHE_DIR);
        try {
            diskLruCache = DiskLruCache.open(file, APP_VERSION, VALUE_COUNT, MAX_SIZE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void put(String key, Value value) {
        DiskLruCache.Editor editor = null;
        OutputStream outputStream = null;
        try {
            editor = diskLruCache.edit(key);

            outputStream = editor.newOutputStream(0);
            Bitmap bitmap = value.getBitmap();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
            //失败
            try {
                editor.abort();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                editor.commit();
            } catch (IOException e) {
                e.printStackTrace();
                Log.d(TAG, "put {}" + e.getMessage());
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.d(TAG, "put {关流}" + e.getMessage());
                }
            }

        }
    }

    public Value get(String key) {
        Tool.checkNotString(key);
        InputStream inputStream = null;
        Value value = Value.getInstance();
        try {
            DiskLruCache.Snapshot snapshot = diskLruCache.get(key);
            if (null != snapshot) {
                inputStream = snapshot.getInputStream(0);
                Bitmap result = BitmapFactory.decodeStream(inputStream);
                value.setBitmap(result);
                //保存key
                value.setmKey(key);
                return value;
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

}
