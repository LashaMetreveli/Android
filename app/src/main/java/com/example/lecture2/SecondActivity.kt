package com.example.lecture2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*


class SecondActivity : AppCompatActivity() {

    private var firstName = ""
    private var lastName = ""
    private var email = ""
    private var gender = ""
    private var birthDate = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        init()
    }

    private fun init() {
        val intent = intent.extras
        firstName = intent!!.getString("firstName", "")
        lastName = intent.getString("lastName", "")
        email = intent.getString("email", "")
        gender = intent.getString("gender", "")
        birthDate = intent.getString("birthDate", "")

        firstNameTextView.text = firstName
        lastNameTextView.text = lastName
        emailTextView.text = email
        genderTextView.text = gender
        birthDayTextView.text = birthDate

        editProfileButton.setOnClickListener {
            openMainActivity()

        }
    }

    private fun openMainActivity(){
        var intent = Intent(this,MainActivity::class.java)

        startActivity(intent)
    }


}