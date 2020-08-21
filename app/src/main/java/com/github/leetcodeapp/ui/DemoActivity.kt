package com.github.leetcodeapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.github.leetcodeapp.R
import com.github.leetcodeapp.demo.Api
import com.github.leetcodeapp.demo.bean.UserInfo
import com.github.leetcodeapp.demo.facade.Facade
import com.github.leetcodeapp.demo.factory.PropertiesFactory

class DemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)

        var api :Api = PropertiesFactory.create(this)

        var user:UserInfo =api.create();

        var userInfo :String =   user?.toString();
        Toast.makeText(this,userInfo,Toast.LENGTH_LONG).show()


        val facade:Facade = Facade("xxx")

        facade?.loader();
    }
}