package com.example.landscapelayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SquareActivity : AppCompatActivity() {

    private lateinit var squareImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_square)

        squareImage = findViewById(R.id.square)

        val squareSize = intent.getIntExtra(EXTRA_SQUARE_SIZE, 100)

        squareImage.layoutParams.width = squareSize
        squareImage.layoutParams.height = squareSize
    }
}