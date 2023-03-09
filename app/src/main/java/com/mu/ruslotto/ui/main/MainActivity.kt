package com.mu.ruslotto.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mu.ruslotto.databinding.ActivityMainBinding
import com.mu.ruslotto.utils.YEAR_START
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    //private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        setCopyright()
    }

    private fun setCopyright() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val copyright = binding.mainFooter.copyrightYear

        if (year != YEAR_START) {
            val strYear = "$YEAR_START-$year"
            copyright.text = strYear
        } else {
            copyright.text = YEAR_START.toString()
        }
    }
}