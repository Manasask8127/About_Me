package com.example.manasask.aboutme

import android.content.Context
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickName(it)
        }

    }

    private fun addNickName(view : View)
    {
        val editNickName = findViewById<EditText>(R.id.nickname_edit)
        val textNickname = findViewById<TextView>(R.id.nickname_text)

        textNickname.text=editNickName.text
        editNickName.visibility=View.GONE
        view.visibility=View.GONE
        textNickname.visibility=View.VISIBLE

        val imm=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }
}