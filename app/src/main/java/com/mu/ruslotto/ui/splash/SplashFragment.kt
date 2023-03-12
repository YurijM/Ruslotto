package com.mu.ruslotto.ui.splash

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.mu.ruslotto.R
import com.mu.ruslotto.database.RuslottoDatabase
import com.mu.ruslotto.database.RuslottoRepository
import com.mu.ruslotto.ui.main.MainActivity
import com.mu.ruslotto.utils.DAO
import com.mu.ruslotto.utils.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashFragment : Fragment(R.layout.fragment_splash) {
    private val pause = 3000L

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val database: RuslottoDatabase by lazy { RuslottoDatabase.getDatabase(requireContext()) }

        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch(Dispatchers.IO) {
            //DAO = RuslottoDatabase.getDatabase(requireContext()).getRuslottoDao()
            DAO = database.getRuslottoDao()
            REPOSITORY = RuslottoRepository(DAO)

            delay(pause)

            withContext(Dispatchers.Main) {
                val intent = Intent(requireContext(), MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
            }

            //val navController = requireActivity().supportFragmentManager.findFragmentById(R.id.mainContainer) as NavHostFragment

            //val navController = (supportFragmentManager.findFragmentById(R.id.mainContainer) as NavHostFragment).navController
            //navController.navigate(R.id.issuesFragment)

        }
    }
}