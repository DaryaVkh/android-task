package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class SecondaryActivity : AppCompatActivity() {
    private var square: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)

        val message = intent.getStringExtra(EXTRA_MESSAGE)
        square = message?.toInt() ?: 0
        findViewById<TextView>(R.id.textView).apply {
            text = message
        }

        Log.i("SecondaryActivity", "On create")
    }

    override fun onStart() {
        super.onStart()
        Log.i("SecondaryActivity", "On start")
    }

    override fun onResume() {
        super.onResume()
        Log.i("SecondaryActivity", "On resume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("SecondaryActivity", "On pause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("SecondaryActivity", "On stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("SecondaryActivity", "On destroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("SecondaryActivity", "On restart")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(SQUARE_KEY, square)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        square = savedInstanceState.getInt(SQUARE_KEY)
    }

    companion object {
        const val SQUARE_KEY = "SQUARE_KEY"
    }
}