package com.github.leetcodeapp.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import com.github.leetcodeapp.Book;
import com.github.leetcodeapp.BookManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: douruanliang
 * @date: 2020/8/22
 */
public class BookCheckService extends Service {

    public final String TAG = this.getClass().getSimpleName();
    private List<Book> mBooks = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        Book firstBook = new Book();
        firstBook.setPrice(1000);
        firstBook.setName("百科全书");
        mBooks.add(firstBook);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new BookManager.Stub() {
            @Override
            public List<Book> getList() throws RemoteException {
                if (!mBooks.isEmpty()) {
                    return mBooks;
                }
                return null;
            }

            @Override
            public Book addBook(Book k) throws RemoteException {

                // in 服务端会接受客户端传过来的完整数据，但客户端的数据不会受服务端的修改而变化(不成立)
                if (k != null) {
                    k.setPrice(100);
                }
                mBooks.add(k);
                Log.e(TAG, "invoking addBookIn() method , now the list is : " + mBooks.toString());
                return k;
            }

            @Override
            public Book addBookOut(Book k) throws RemoteException {
                mBooks.add(k);
                Log.e(TAG, "invoking addBookOut() method , now the list is : " + mBooks.toString());
                return k;
            }

            @Override
            public Book addBookInOut(Book k) throws RemoteException {
                if (k == null) {
                    k = new Book();
                    k.setName("serviceInOut");
                    mBooks.add(k);
                }
                Log.e(TAG, "invoking addBookInOut() method , now the list is : " + mBooks.toString());
                return k;
            }
        };
    }
}
