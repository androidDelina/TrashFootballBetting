package com.example.trashfootball

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class EndActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)
        val scoreREs = findViewById<TextView>(R.id.scoreRes)
        val score = intent.getIntExtra("score", 100)
        scoreREs.text = score.toString()
    }
}