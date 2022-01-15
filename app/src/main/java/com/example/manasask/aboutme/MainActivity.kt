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
import androidx.databinding.DataBindingUtil
import com.example.manasask.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val myName: MyName = MyName("Manasa")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
       // findViewById<Button>(R.id.done_button).setOnClickListener {
          //  addNickName(it)
      //  }
        binding.myName=myName
        binding.doneButton.setOnClickListener {
            addNickName(it)
        }

    }

    private fun addNickName(view : View)
    {
        //val editNickName = findViewById<EditText>(R.id.nickname_edit)
        //val textNickname = findViewById<TextView>(R.id.nickname_text)

        binding.apply {
            myName?.nickName=nicknameEdit.text.toString()
            invalidateAll()
            //binding.nicknameText.text= binding.nicknameEdit.text
            binding.nicknameEdit.visibility=View.GONE
            binding.doneButton.visibility=View.GONE
            binding.nicknameText.visibility=View.VISIBLE}

        //textNickname.text=editNickName.text
//        editNickName.visibility=View.GONE
//        view.visibility=View.GONE
//        textNickname.visibility=View.VISIBLE

        val imm=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }
}