package com.maylinda.cupcake
//TODO 3: Dari AndroidManifast menuju MainActivity, pada file .kt ini memanggil layout untuk ditampilkan, yakni activity_main
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       //Pada MainActivity menggunakan navigation fragment
        //karena adanya val maka tidak dapat diakses diluar class
        //Mendukung Fragment
        //Memanggil id fragment nav_host_fragment yang ada pada activity_main
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController


        setupActionBarWithNavController(navController)
    }
}