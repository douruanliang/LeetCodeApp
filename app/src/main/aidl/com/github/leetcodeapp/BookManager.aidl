// BookManager.aidl
package com.github.leetcodeapp;

// Declare any non-default types here with import statements
import com.github.leetcodeapp.Book;
interface BookManager {

   List<Book> getList();
   Book addBook(in Book k);
   Book addBookOut(out Book k);
   Book addBookInOut(inout Book k);

}
