package com.example.practice16

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedP = this.getSharedPreferences("CHANGE_THEME", MODE_PRIVATE)

        val theme = sharedP.getInt("my_theme", R.style.MyTheme_Dark)

        setTheme(theme)

        setContentView(R.layout.activity_main)
    }

    fun changeTheme(view: View){
        val shared = getSharedPreferences("CHANGE_THEME", MODE_PRIVATE)
        val theme = shared.getInt("my_theme", R.style.MyTheme_Dark)
        if (theme==R.style.MyTheme_Dark)
        {

            shared.edit().clear().apply()

            shared.edit().putInt("my_theme", R.style.MyTheme_Light).apply()

            recreate()

        }
        else
        {

            shared.edit().clear().apply()

            shared.edit().putInt("my_theme", R.style.MyTheme_Dark).apply()

            recreate()

        }
    }

}