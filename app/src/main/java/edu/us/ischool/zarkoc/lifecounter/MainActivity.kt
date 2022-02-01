package edu.us.ischool.zarkoc.lifecounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val plusOneOne = findViewById<TextView>(R.id.plusOne_1)
        val plusOneTwo = findViewById<TextView>(R.id.plusOne_2)
        val plusOneThree = findViewById<TextView>(R.id.plusOne_3)
        val plusOneFour = findViewById<TextView>(R.id.plusOne_4)
        plusOneOne.setOnClickListener(this)
        plusOneTwo.setOnClickListener(this)
        plusOneThree.setOnClickListener(this)
        plusOneFour.setOnClickListener(this)

        val plusFiveOne = findViewById<TextView>(R.id.plusFive_1)
        val plusFiveTwo = findViewById<TextView>(R.id.plusFive_2)
        val plusFiveThree = findViewById<TextView>(R.id.plusFive_3)
        val plusFiveFour = findViewById<TextView>(R.id.plusFive_4)
        plusFiveOne.setOnClickListener(this)
        plusFiveTwo.setOnClickListener(this)
        plusFiveThree.setOnClickListener(this)
        plusFiveFour.setOnClickListener(this)

        val minusOneOne = findViewById<TextView>(R.id.minusOne_1)
        val minusOneTwo = findViewById<TextView>(R.id.minusOne_2)
        val minusOneThree = findViewById<TextView>(R.id.minusOne_3)
        val minusOneFour = findViewById<TextView>(R.id.minusOne_4)
        minusOneOne.setOnClickListener(this)
        minusOneTwo.setOnClickListener(this)
        minusOneThree.setOnClickListener(this)
        minusOneFour.setOnClickListener(this)

        val minusFiveOne = findViewById<TextView>(R.id.minusFive_1)
        val minusFiveTwo = findViewById<TextView>(R.id.minusFive_2)
        val minusFiveThree = findViewById<TextView>(R.id.minusFive_3)
        val minusFiveFour = findViewById<TextView>(R.id.minusFive_4)
        minusFiveOne.setOnClickListener(this)
        minusFiveTwo.setOnClickListener(this)
        minusFiveThree.setOnClickListener(this)
        minusFiveFour.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val scoreOne = findViewById<TextView>(R.id.scoreTrack_1)
        val scoreTwo = findViewById<TextView>(R.id.scoreTrack_2)
        val scoreThree = findViewById<TextView>(R.id.scoreTrack_3)
        val scoreFour = findViewById<TextView>(R.id.scoreTrack_4)

        when (v.id) {
            R.id.plusOne_1 -> adjustScore(scoreOne, 1)
            R.id.plusOne_2 -> adjustScore(scoreTwo, 1)
            R.id.plusOne_3 -> adjustScore(scoreThree, 1)
            R.id.plusOne_4 -> adjustScore(scoreFour, 1)
            R.id.plusFive_1 -> adjustScore(scoreOne, 5)
            R.id.plusFive_2 -> adjustScore(scoreTwo, 5)
            R.id.plusFive_3 -> adjustScore(scoreThree, 5)
            R.id.plusFive_4 -> adjustScore(scoreFour, 5)
            R.id.minusOne_1 -> adjustScore(scoreOne, -1)
            R.id.minusOne_2 -> adjustScore(scoreTwo, -1)
            R.id.minusOne_3 -> adjustScore(scoreThree, -1)
            R.id.minusOne_4 -> adjustScore(scoreFour, -1)
            R.id.minusFive_1 -> adjustScore(scoreOne, -5)
            R.id.minusFive_2 -> adjustScore(scoreTwo, -5)
            R.id.minusFive_3 -> adjustScore(scoreThree, -5)
            R.id.minusFive_4 -> adjustScore(scoreFour, -5)
            else -> {
                Log.e("TESTING", "ID: " + v.id);
            }
        }
    }

    private fun isNumber(s: String?): Boolean {
        return if (s.isNullOrEmpty()) false else s.all { Character.isDigit(it) }
    }

    private fun adjustScore(player: TextView, weight: Int) {
        var playerScoreString = player.text.toString()

        if (isNumber(playerScoreString)) {
            var playerScore = playerScoreString.toInt()

            if (playerScore + weight in 1..999) {
                player.text = (playerScore + weight).toString()
            } else if (playerScore + weight >= 999) {
                player.text = "999"
            } else {
                player.text = "Out!"

                val loser = findViewById<TextView>(R.id.loserText)
                when (player.id) {
                    R.id.scoreTrack_1 -> loser.text = "Player 1 LOSES!"
                    R.id.scoreTrack_2 -> loser.text = "Player 2 LOSES!"
                    R.id.scoreTrack_3 -> loser.text = "Player 3 LOSES!"
                    R.id.scoreTrack_4 -> loser.text = "Player 4 LOSES!"
                }
            }
        }
    }
}