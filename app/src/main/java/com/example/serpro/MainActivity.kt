package com.example.serpro

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.serpro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var loginAct: LoginActivity? = null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //INSTANCIAMOS LA ACTIVIDAD Login
        loginAct = LoginActivity()
        //LOGICA DE SELECCIÓN DE ACTIVITY
        if (LoginActivity.Companion.access) {
            cargaMenu()
        } else {
            //CARGA PORTADA
            val miIntent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(miIntent)
            finish()
        }


    }

    fun cargaMenu() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}