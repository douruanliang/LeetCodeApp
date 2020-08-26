package com.mobile.glidelibrary;

import com.mobile.glidelibrary.cache.MemoryCache;
import com.mobile.glidelibrary.cache.MemoryCacheCallback;
import com.mobile.glidelibrary.resource.Value;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {

        MemoryCache cache = new MemoryCache(5);
        cache.put("12345", Value.getInstance());

        final Value v = cache.get("12345");
        cache.removeBy("123456");
        cache.setMemoryCacheCallback(new MemoryCacheCallback() {
            @Override
            public void entryRemoveMemoryCache(String key, Value oldValue) {
                System.out.println("remove key" + key);
            }
        });
    }
}