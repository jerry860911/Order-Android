package com.example.order

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*

class SecActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sec)

        //XML元件
        val btn_send =findViewById<Button>(R.id.btn_send)
        val ed_drink = findViewById<EditText>(R.id.ed_drink)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val radioGroup2 = findViewById<RadioGroup>(R.id.radioGroup2)

        btn_send.setOnClickListener{
            if (ed_drink.length() < 1 )
                Toast.makeText(this,"請輸入飲料名稱",Toast.LENGTH_SHORT).show()
            else{
                //宣告Bundle
                val b = Bundle()
                //取得EditText字串內容，把飲料內容資訊放入
                b.putString("drink",ed_drink.text.toString())
                b.putString("sugar",radioGroup.findViewById<RadioButton>(radioGroup.checkedRadioButtonId).text.toString())
                b.putString("ice",radioGroup2.findViewById<RadioButton>(radioGroup2.checkedRadioButtonId).text.toString())
                //用Activity.RESULT_OK標記執行狀態並記錄Intent
                setResult(Activity.RESULT_OK, Intent().putExtras(b))
                finish()
            }
        }


    }
}