package com.example.diceroll

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)


        rollButton.setOnClickListener { rollDice() }
        rollDice()
    }

    private fun rollDice() {

        val dice = Dice(6)
        val rollResult= dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView)
        diceImage.setImageResource(R.drawable.dice_1)
        val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
        val diceShow = when (rollResult) {
            1 -> (R.drawable.dice_1)
            2 -> (R.drawable.dice_2)
            3 -> (R.drawable.dice_3)
            4 -> (R.drawable.dice_4)
            5 -> (R.drawable.dice_5)
            else -> (R.drawable.dice_6)
        }
        diceImage.setImageResource(diceShow)
        toast.show()
    }
}
       // val luckyNumber = 4
        //when (rollResult) {
          //  luckyNumber -> println("You won!")
            //1 -> println("So sorry! You rolled a 1. Try again!")
            //2 -> println("Sadly, you rolled a 2. Try again!")
            //3 -> println("Unfortunately, you rolled a 3. Try again!")
            //4 -> println("No luck! You rolled a 4. Try again!")
            //5 -> println("Don't cry! You rolled a 5. Try again!")
            //6 -> println("Apologies! you rolled a 6. Try again!")
      //val resultTextView: TextView = findViewById(R.id.textView)
        // resultTextView.text = rollResult.toString()

    class Dice(private val numSides: Int) {

        fun roll(): Int {
            return (1..numSides).random()
        }
    }
