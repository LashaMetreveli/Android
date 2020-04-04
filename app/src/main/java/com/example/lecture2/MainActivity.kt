package com.example.lecture2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }



    private fun init() {
        openSecondActivity.setOnClickListener {
            openSecondActivity()
        }

    }


    private fun openSecondActivity(){
        val intent = Intent(this,SecondActivity::class.java)

        intent.putExtra("firstName", firstNameEditText.text.toString())
        intent.putExtra("lastName", lastNameEditText.text.toString())
        intent.putExtra("email", emailEditText.text.toString())
        intent.putExtra("gender", genderEditText.text.toString())
        intent.putExtra("birthDate", birthDayEditText.text.toString())

        startActivity(intent)
    }



}
