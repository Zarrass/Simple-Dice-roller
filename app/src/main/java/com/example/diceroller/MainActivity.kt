package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
// Слушаем кнопки
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        val rollButton20: Button = findViewById(R.id.button2)
        rollButton20.setOnClickListener { rollDice20() }

    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // Ищем привязанное изображение
        val diceImage: ImageView = findViewById(R.id.dice)
        // Выбираем изображение в зависимости от результата броска
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
        // И привязываем его
        diceImage.contentDescription = diceRoll.toString()
    }

    private fun rollDice20() {
        val dice2 = Dice(20)
        val diceRoll = dice2.roll()
        val resultTextView: TextView = findViewById(R.id.textView2)
        resultTextView.text = diceRoll.toString()
    }
}

class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}