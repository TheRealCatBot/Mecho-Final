package com.example.finaluri

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlin.random.Random


class TicTacToe : AppCompatActivity(), View.OnClickListener {

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button

    private lateinit var resetButton: Button

    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()
    private var svla = 0
    private var activePlayer = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tictactoe)


        init()
    }

    private fun init() {
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)

        resetButton = findViewById(R.id.resetButton)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)

        resetButton.setOnClickListener {
            resetGame()
        }
    }

    override fun onClick(clickedView: View?) {
        if (clickedView is Button) {
            val buttonNumber = when (clickedView.id) {
                R.id.button1 -> 1
                R.id.button2 -> 2
                R.id.button3 -> 3
                R.id.button4 -> 4
                R.id.button5 -> 5
                R.id.button6 -> 6
                R.id.button7 -> 7
                R.id.button8 -> 8
                R.id.button9 -> 9
                else -> 0
            }

            if (buttonNumber != 0) {
                playGame(clickedView, buttonNumber)
            }
        }
    }

    private fun playGame(clickedView: Button, buttonNumber: Int) {
        if (activePlayer == 1) {
            if (clickedView.text.toString().isEmpty()) {
                clickedView.text = "X"
                clickedView.setBackgroundColor(Color.RED)
                firstPlayer.add(buttonNumber)
                svla += 1
                activePlayer = 2
                check()
                if (activePlayer == 2) {
                    randSvla()
                    check()
                }
            }
        }
    }

    private fun check() {
        var winnerPlayer = 0

        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {
            winnerPlayer = 1
        } else if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)) {
            winnerPlayer = 2
        } else if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
            winnerPlayer = 1
        } else if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)) {
            winnerPlayer = 2
        } else if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        } else if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        } else if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        } else if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        } else if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {
            winnerPlayer = 1
        } else if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)) {
            winnerPlayer = 2
        } else if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        } else if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        } else if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        } else if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        } else if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        } else if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }

        if (winnerPlayer != 0) {
            when (winnerPlayer) {
                1 -> Toast.makeText(this, "X wins!", Toast.LENGTH_SHORT).show()
                2 -> Toast.makeText(this, "O wins!", Toast.LENGTH_SHORT).show()
            }
            disableButtons()
        } else if (svla == 9) {
            Toast.makeText(this, "It's a tie", Toast.LENGTH_SHORT).show()
            disableButtons()
        }
    }

    private fun randSvla() {
        val buttons = listOf(button1, button2, button3, button4, button5, button6, button7, button8, button9)
        val availableButtons = buttons.filter { it.isEnabled && it.text.toString().isEmpty() }

        if (availableButtons.isNotEmpty()) {
            val randInt = Random.nextInt(availableButtons.size)
            val selectedButton = availableButtons[randInt]
            selectedButton.text = "O"
            selectedButton.setBackgroundColor(Color.YELLOW)
            selectedButton.isEnabled = false
            secondPlayer.add(buttons.indexOf(selectedButton) + 1)
            svla += 1
            activePlayer = 1
        }
    }

    private fun resetGame() {
        val buttons = listOf(button1, button2, button3, button4, button5, button6, button7, button8, button9)
        buttons.forEach{button ->
            button.text = ""
            button.setBackgroundColor(Color.parseColor("#6200EE"))
            button.isEnabled = true
        }
        firstPlayer.clear()
        secondPlayer.clear()
        svla = 0
        activePlayer = 1
    }


    private fun disableButtons() {
        button1.isEnabled = false
        button2.isEnabled = false
        button3.isEnabled = false
        button4.isEnabled = false
        button5.isEnabled = false
        button6.isEnabled = false
        button7.isEnabled = false
        button8.isEnabled = false
        button9.isEnabled = false
    }




}