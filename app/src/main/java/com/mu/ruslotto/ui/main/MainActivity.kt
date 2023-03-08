package com.mu.ruslotto.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.mu.ruslotto.R
import com.mu.ruslotto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    //private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = (supportFragmentManager.findFragmentById(R.id.mainContainer) as NavHostFragment).navController
        val graph = navController.navInflater.inflate(R.navigation.main_graph)
        graph.setStartDestination(R.id.issuesFragment)
        navController.graph = graph
    }
}