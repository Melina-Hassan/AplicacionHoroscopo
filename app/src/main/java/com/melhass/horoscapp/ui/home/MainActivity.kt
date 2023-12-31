package com.melhass.horoscapp.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.melhass.horoscapp.R
import com.melhass.horoscapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        iniciarNavegacion()
    }

    private fun iniciarNavegacion() {
        val navHost: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.fcvMain) as NavHostFragment
        navController = navHost.navController
        binding.bnvMenu.setupWithNavController(navController)
    }
}