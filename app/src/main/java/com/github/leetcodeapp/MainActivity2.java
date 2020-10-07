package com.github.leetcodeapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.leetcodeapp.view.test.MyButton;

public class MainActivity2 extends AppCompatActivity {

    MyButton myButton;

    LinearLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_demo);
        root = findViewById(R.id.main_layout) ;
        myButton = findViewById(R.id.id_btn);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("xx", "setOnClickListener");
            }
        });
        myButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("xx", "setOnTouchListener -onTouch" +event.getAction());
                return true;
            }
        });

        LayoutInflater inflater =LayoutInflater.from(this);

        View  btn = inflater.inflate(R.layout.button_layout,root,false);

        root.addView(btn);
        Toast.makeText(this,"---"+(btn ==null),Toast.LENGTH_LONG).show();
        //root.addView(btn);

    }
/*
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("xx", "MainActivity的dispatchTouchEvent" + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("xx", "MainActivity的onTouchEvent" + event.getAction());
        return super.onTouchEvent(event);
    }*/

    /*public void dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.i("xx", "MainActivity的dispatchTouchEvent" + ev?.getAction());
        return super.dispatchTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.i("xx", "MainActivity的onTouchEvent" + event?.getAction());
        return super.onTouchEvent(event)
    }*/
}