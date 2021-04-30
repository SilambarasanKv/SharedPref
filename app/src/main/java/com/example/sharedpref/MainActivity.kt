package com.example.sharedpref

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    var isRemembered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        isRemembered = sharedPreferences.getBoolean("CHECKBOX", false)

        if (isRemembered) {

            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            finish()

        }

        btnLogin.setOnClickListener {
            val name: String = etEnterYourName.text.toString()
            val password: Int = etEnterYourPassword.text.toString().toInt()
            val checked: Boolean = checkBox.isChecked

            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("NAME", name)
            editor.putInt("PASSWORD", password)
            editor.putBoolean("CHECKBOX", checked)
            editor.apply()

            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}