package com.mobile.glidelibrary.utils;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author: douruanliang
 * @date: 2020/8/26
 */
public class Tool {
    private static final int HASH_MULTIPLTER = 31;
    private static final int HASH_ACCUMULATOR = 17;

    private static final char[] HEX_CHAR_ARRAY = "0123456789abcdef".toCharArray();
    private static final char[] SHA_256_CHARS = new char[64];

    public Tool() {
    }

    public static String sha256BytesToHex(byte[] bytes) {
        synchronized (SHA_256_CHARS) {
            return bytesToHex(bytes, SHA_256_CHARS);

        }
    }

    private static String bytesToHex(byte[] bytes, char[] hexChars) {
        int v;
        for (int j = 0; j < bytes.length; j++) {
            v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_CHAR_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_CHAR_ARRAY[v & 0x0f];
        }
        return new String(hexChars);
    }

    public static int getSize(Bitmap bitmap) {

        return getBitmapSize(bitmap);
    }

    private static int getBitmapSize(Bitmap bitmap) {
        if (bitmap.isRecycled()) {
            throw new IllegalStateException("cannot obtain size for recycled Bitmap:" +
                    bitmap + "[" + bitmap.getWidth() + "X" + bitmap.getHeight() + "]" + bitmap.getConfig());
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            return bitmap.getAllocationByteCount();
        }

        return bitmap.getHeight() * bitmap.getWidth();
    }

    public static int getBitmapByteSize(int w, int h, Bitmap.Config config) {
        return w * h * getBytesPerPixel(config);
    }

    private static int getBytesPerPixel(Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int bytePerPixel;
        switch (config) {
            case ALPHA_8:
                bytePerPixel = 1;
                break;
            case RGB_565:
            case ARGB_4444:
                bytePerPixel = 2;
                break;
            case RGBA_F16:
                bytePerPixel = 8;
                break;
            case ARGB_8888:
            default:
                bytePerPixel = 4;
                break;
        }
        return bytePerPixel;
    }

    public static void assertMainThread() {
        if (!isOnMainThread()) {
            throw new IllegalArgumentException("Yue must call this method on the main thread");
        }
    }

    public static void assertBackgroundThread() {
        if (!isOnBackgroundThread()) {
            throw new IllegalArgumentException("Yue must call this method on the word thread");
        }
    }

    public static boolean isOnMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean isOnBackgroundThread() {
        return !isOnMainThread();
    }

    /**
     * 利用原生 java 摘要实现SHA256加密
     *
     * @param str
     * @return
     */
    public static String getSHA256StringJava(String str) {
        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            encodeStr = bytes2Hex(messageDigest.digest());
            Log.d("RequestTargetEngine", " SHA_256..encodeStr >>>>" + encodeStr);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return encodeStr;
    }

    /**
     * bytes 转 String
     * @param bytes
     * @return
     */
    private static String bytes2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

    public static void checkNotEmpty(Bitmap bitmap){

        if (null == bitmap){
            throw new IllegalArgumentException("Must not be empty, new the parameter bitmap is null");
        }
    }
    public static String checkNotString(String str){

        if (TextUtils.isEmpty(str)){
            throw new IllegalArgumentException("Must not be empty, new the parameter str is null");
        }
        return str;
    }
}
