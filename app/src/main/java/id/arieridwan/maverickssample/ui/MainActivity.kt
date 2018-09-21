package id.arieridwan.maverickssample.ui

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.airbnb.mvrx.BaseMvRxActivity
import id.arieridwan.maverickssample.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseMvRxActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigation()
    }

    private fun setupNavigation() {
        val navController = findNavController(R.id.my_nav_host_fragment)
        bottom_navigation.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp() =
            findNavController(R.id.my_nav_host_fragment).navigateUp()

}
