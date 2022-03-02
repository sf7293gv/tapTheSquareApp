package com.example.landscapelayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView

const val EXTRA_SQUARE_SIZE = "com.example.landscapelayout.tap_the_square.SQUARE.SIZE"

class MainActivity : AppCompatActivity() {

    private lateinit var seekBar: SeekBar
    private lateinit var seekBarLabel: TextView
    private lateinit var showSquareButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seekBar = findViewById(R.id.seek_bar)
        seekBarLabel = findViewById(R.id.seek_bar_label)
        showSquareButton = findViewById(R.id.show_square_btn)

        val initialProgress = seekBar.progress
        updateLabel(initialProgress)

        // update label as seekbar changes

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBarComponent: SeekBar?, progress: Int, fromUser: Boolean) {
                updateLabel(progress)
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

        showSquareButton.setOnClickListener {
            showSquare()
        }

    }

    private fun updateLabel(progress: Int) {
        seekBarLabel.text = getString(R.string.seekbar_value_message, progress)
    }

    private fun showSquare() {
        // launch square activity, set size of square based on the progress
        val showSquareIntent = Intent(this, SquareActivity::class.java)
        showSquareIntent.putExtra(EXTRA_SQUARE_SIZE, seekBar.progress)
        startActivity(showSquareIntent)
    }

}