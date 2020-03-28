package com.example.lecture2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        loginButtom.setOnClickListener {
            if (emailEditText.text.toString().isNotEmpty() && passwordEditText.text.toString()
                    .isNotEmpty()
            ) {
                Toast.makeText(this, "Login is success", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }


}
