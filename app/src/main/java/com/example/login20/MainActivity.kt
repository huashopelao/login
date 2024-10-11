package com.example.login20

import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.login20.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar la toolbar
        setSupportActionBar(binding.toolbar)
        // Configurar el NavController principal
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as? NavHostFragment
        if (navHostFragment != null){
            navController = navHostFragment.navController
            setupActionBarWithNavController(navController)
            setupDestinationChangedListener()
        } else{
            throw  RuntimeException("NavHostFragment not found with ID R.id.nav_host_fragment")
        }
    }

private fun setupDestinationChangedListener() {
    navController.addOnDestinationChangedListener { _, destination, _ ->
        Log.d(tag:"MainActivity", msg:"Navigated to ${destination.label}")
        when (destination.id) {
            R.id.registerFragment -> {
                supportActionBar?.title = "Registro"
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
            }
 //           R.id.homeFragment -> {
 //               supportActionBar?.title = "HomeApp"
 //           }
            else -> {
                supportActionBar?.title = "Login"
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
            }
        }
    }


        override fun onSupportNavigateUp(): Boolean {
            return navController.navigateUp() || super.onSupportNavigateUp()
        }

        overrride fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.toolbar, menu)
            return  true
        }

        override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
            // todo configurar el logout
            return super.onPrepareOptionsMenu(menu)
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            when (item.itemId){
                R.id.action_logout -> {
                    navController.navigate(R.id.action_homeFragment_to_loginFragment)
                    return true
                }
                R.id.action_settings -> {
                    Toast.makeText(this, text:"Settings", Toast.LENGTH_SHORT).show()
                    return true
                }
            }
                return super.onOptionsItemSelected(item)
    }






}










}
