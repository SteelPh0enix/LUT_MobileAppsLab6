package com.example.basiclab

import android.graphics.Color
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.findNavController
import java.util.*

class MainActivity : AppCompatActivity() {

    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        navController = findNavController(R.id.nav_host_fragment)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val rand = Random()
        val color = Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256))

        when (item.itemId) {
            R.id.action_settings -> {
                Snackbar.make(findViewById(R.id.fab), "Settings action pressed", Snackbar.LENGTH_LONG).show()
            }
            R.id.action_goto_first_fragment -> {
                navController?.navigate(R.id.action_global_FirstFragment, bundleOf("backgroundColor" to color));
                Snackbar.make(findViewById(R.id.fab), "Jumped to first fragment", Snackbar.LENGTH_LONG).show()
            }
            R.id.action_goto_second_fragment -> {
                navController?.navigate(R.id.action_global_SecondFragment, bundleOf("backgroundColor" to color));
                Snackbar.make(findViewById(R.id.fab), "Jumped to second fragment", Snackbar.LENGTH_LONG).show()
            }
            R.id.action_goto_third_fragment -> {
                navController?.navigate(R.id.action_global_ThirdFragment, bundleOf("backgroundColor" to color));
                Snackbar.make(findViewById(R.id.fab), "Jumped to third fragment", Snackbar.LENGTH_LONG).show()
            }
        }

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            else -> super.onOptionsItemSelected(item)
        }
    }
}