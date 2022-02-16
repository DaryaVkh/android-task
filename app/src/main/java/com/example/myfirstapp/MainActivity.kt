package com.example.myfirstapp

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

class MainActivity : AppCompatActivity() {
    private var number: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.textView).apply {
            text = "$number"
        }

        Log.i("MainActivity", "On create")
    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "On start")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "On resume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity", "On pause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity", "On stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity", "On destroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MainActivity", "On restart")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        setContentView(R.layout.activity_main)
        number++
        findViewById<TextView>(R.id.textView).apply {
            text = "$number"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(NUMBER_KEY, number)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        number = savedInstanceState.getInt(NUMBER_KEY)
    }

    fun goToSecondaryActivity(view: View) {
        val message = "${number * number}"
        val intent = Intent(this, SecondaryActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

    companion object {
        const val NUMBER_KEY = "NUMBER_KEY"
    }
}