package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadData()

        binding.btn.setOnClickListener {
            saveData()
        }
    }
        private fun loadData() {
            val sharedPreferences= getSharedPreferences("share", Context.MODE_PRIVATE)
            val saveString = sharedPreferences.getString("key", null)

            binding.text2.text= saveString


    }

    private fun saveData() {
        val instext = binding.search.text.toString()
        binding.text2.text = instext

        val sharedPreferences= getSharedPreferences("share", Context.MODE_PRIVATE)
        val editor= sharedPreferences.edit()
        editor.apply{
            putString("key", instext)
        }.apply()

    }   
}
