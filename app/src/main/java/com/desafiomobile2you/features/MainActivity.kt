package com.desafiomobile2you.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.desafiomobile2you.R
import com.desafiomobile2you.databinding.ActivityMainBinding
import com.desafiomobile2you.features.home.view.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment = HomeFragment()
        supportFragmentManager.beginTransaction()
            .replace(binding.container.id,fragment)
            .addToBackStack(null).commit()
    }
}