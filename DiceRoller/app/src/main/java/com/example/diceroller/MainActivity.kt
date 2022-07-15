package com.example.diceroller

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        val textView: TextView = findViewById(R.id.textView)
        rollDice()
        textView.text = getString(R.string.start_text)
        rollButton.setOnClickListener { rollDice() }
    }

    @SuppressLint("SetTextI18n")
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val luckyNum = dice.luckyNum()
        val diceImage: ImageView = findViewById(R.id.imageView)
        val textView: TextView = findViewById(R.id.textView)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        if (diceRoll == luckyNum){
            textView.text = "You are lucky"
        }else textView.text = "bad luck,try again"
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
    fun luckyNum():Int{
        return (1..numSides).random()
    }
}