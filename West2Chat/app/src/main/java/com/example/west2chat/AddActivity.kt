package com.example.west2chat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        submit.setOnClickListener {
            val intent=Intent()
            intent.putExtra("data_return",Item(name.text.toString(),create.text.toString(),R.drawable.zb))
            setResult(RESULT_OK,intent)
            finish()
        }

    }
}