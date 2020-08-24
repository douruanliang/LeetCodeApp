package com.github.leetcodeapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author: douruanliang
 * @date: 2020/8/22
 */
public class Book implements Parcelable {

    private String name;
    private int price;


    public Book() {
    }

    protected Book(Parcel in) {
        name = in.readString();
        price = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(price);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public void readFromParcel(Parcel in) {
        name = in.readString();
        price = in.readInt();
    }


    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
