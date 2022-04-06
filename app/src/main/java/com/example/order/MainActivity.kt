package com.example.order

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //XML原件
        var btn_choice = findViewById<Button>(R.id.btn_choice)

        //透過intent切換至DecActivity 傳遞requestCode作為識別編號
        btn_choice.setOnClickListener{
            val intent = Intent(this,SecActivity::class.java)
            startActivityForResult(intent,1)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        data?.extras?.let {
            //驗證發出對象，確認SecActivity執行的狀態
            if (requestCode == 1 && resultCode == Activity.RESULT_OK){
                //讀取Bundle資料
                var tv_meal =  findViewById<TextView>(R.id.tv_meal)
                tv_meal.text =
                    "飲料:${it.getString("drink")}\n\n" +
                            "甜度:${it.getString("sugar")}\n\n" +
                            "冰塊:${it.getString("ice")}\n\n"

            }
        }
    }

}