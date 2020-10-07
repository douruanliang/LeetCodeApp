package com.github.leetcodeapp

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.github.leetcodeapp.view.test.MyButton
import com.github.leetcodeapp.view.test.MyImageView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_demo)


        findViewById<MyButton>(R.id.id_btn).setOnClickListener {v -> { println("image")} }

        findViewById<MyImageView>(R.id.id_image).setOnClickListener { v -> { println("image")} }


    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.i("xx", "MainActivity的dispatchTouchEvent" + ev?.getAction());
        return super.dispatchTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.i("xx", "MainActivity的onTouchEvent" + event?.getAction());
        return super.onTouchEvent(event)
    }
}
