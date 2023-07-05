package com.example.finaluri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import java.util.*
import kotlin.math.pow
import kotlin.math.sqrt

class Snake : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snake)

        val board = findViewById<RelativeLayout>(R.id.board)
        val border = findViewById<RelativeLayout>(R.id.relativeLayout)
        val lilu = findViewById<LinearLayout>(R.id.lilu)
        val upButton = findViewById<Button>(R.id.up)
        val downButton = findViewById<Button>(R.id.down)
        val leftButton = findViewById<Button>(R.id.left)
        val rightButton = findViewById<Button>(R.id.right)
        val newgame = findViewById<Button>(R.id.new_game)
        val playagain = findViewById<Button>(R.id.playagain)
        val score = findViewById<Button>(R.id.score)
        val score2 = findViewById<Button>(R.id.score2)
        val food = ImageView(this)
        val snake = ImageView(this)
        val snakeSegments =
            mutableListOf(snake) // Keep track of the position of each snake segment
        val handler = Handler()
        var delayMillis = 30L // Update snake position every 100 milliseconds
        var currentDirection = "right" // Start moving right by default
        var scorex = 0



        board.visibility = View.INVISIBLE
        playagain.visibility = View.INVISIBLE
        score.visibility = View.INVISIBLE
        score2.visibility = View.INVISIBLE
        upButton.visibility = View.INVISIBLE
        downButton.visibility = View.INVISIBLE
        leftButton.visibility = View.INVISIBLE
        rightButton.visibility = View.INVISIBLE

        newgame.setOnClickListener {

            upButton.visibility = View.VISIBLE
            downButton.visibility = View.VISIBLE
            leftButton.visibility = View.VISIBLE
            rightButton.visibility = View.VISIBLE


            board.visibility = View.VISIBLE
            newgame.visibility = View.INVISIBLE
            score2.visibility = View.VISIBLE


            snake.setImageResource(R.drawable.snake1)
            snake.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            board.addView(snake)
            snakeSegments.add(snake) // Add the new snake segment to the list


            var snakeX = snake.x
            var snakeY = snake.y






            food.setImageResource(R.drawable.food)
            food.layoutParams = ViewGroup.LayoutParams(35, 35)

            board.addView(food)

            val random = Random() // create a Random object
            val randomX =
                random.nextInt(801) - 400 // generate a random x-coordinate between -400 and 400
            val randomY =
                random.nextInt(801) - 400 // generate a random y-coordinate between -400 and 400


            food.x = randomX.toFloat()
            food.y = randomY.toFloat()







            fun checkFoodCollision() {
                val distanceThreshold = 50

                val distance = sqrt((snake.x - food.x).pow(2) + (snake.y - food.y).pow(2))

                if (distance < distanceThreshold) { // Check if the distance between the snake head and the food is less than the threshold

                    val newSnake =
                        ImageView(this) // Create a new ImageView for the additional snake segment
                    newSnake.setImageResource(R.drawable.snake1)
                    newSnake.layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                    board.addView(newSnake)

                    snakeSegments.add(newSnake) // Add the new snake segment to the list

                    val randomX =
                        random.nextInt(801) - -100
                    val randomY =
                        random.nextInt(801) - -100


                    food.x = randomX.toFloat()
                    food.y = randomY.toFloat()


                    delayMillis-- // Reduce delay value by 1
                    scorex++

                    score2.text =   "score : " + scorex.toString() // Update delay text view



                }
            }




            val runnable = object : Runnable {
                override fun run() {

                    for (i in snakeSegments.size - 1 downTo 1) { // Update the position of each snake segment except for the head
                        snakeSegments[i].x = snakeSegments[i - 1].x
                        snakeSegments[i].y = snakeSegments[i - 1].y
                    }


                    when (currentDirection) {
                        "up" -> {
                            snakeY -= 10
                            if (snakeY < -590) { // Check if the ImageView goes off the top of the board
                                snakeY = -590f
                                border.setBackgroundColor(getResources().getColor(R.color.red))
                                playagain.visibility = View.VISIBLE
                                lilu.visibility = View.INVISIBLE

                                score.text =   "your score is  " + scorex.toString() // Update delay text view
                                score.visibility = View.VISIBLE
                                score2.visibility = View.INVISIBLE

                            }

                            snake.translationY = snakeY
                        }
                        "down" -> {
                            snakeY += 10
                            val maxY =
                                board.height / 2 - snake.height + 30 // Calculate the maximum y coordinate
                            if (snakeY > maxY) { // Check if the ImageView goes off the bottom of the board
                                snakeY = maxY.toFloat()
                                border.setBackgroundColor(getResources().getColor(R.color.red))
                                playagain.visibility = View.VISIBLE
                                lilu.visibility = View.INVISIBLE

                                score.text =   "your score is  " + scorex.toString() // Update delay text view
                                score.visibility = View.VISIBLE
                                score2.visibility = View.INVISIBLE


                            }
                            snake.translationY = snakeY
                        }
                        "left" -> {
                            snakeX -= 10
                            if (snakeX < -510) { // Check if the ImageView goes off the top of the board
                                snakeX = -510f
                                border.setBackgroundColor(getResources().getColor(R.color.red))
                                playagain.visibility = View.VISIBLE
                                lilu.visibility = View.INVISIBLE
                                score.text =   "your score is  " + scorex.toString() // Update delay text view
                                score.visibility = View.VISIBLE
                                score2.visibility = View.INVISIBLE



                            }
                            snake.translationX = snakeX
                        }
                        "right" -> {
                            snakeX += 10
                            if (snakeX > 510) { // Check if the ImageView goes off the bottom of the board
                                snakeX = 510f
                                border.setBackgroundColor(getResources().getColor(R.color.red))
                                playagain.visibility = View.VISIBLE
                                lilu.visibility = View.INVISIBLE

                                score.text =   "your score is  " + scorex.toString() // Update delay text view
                                score.visibility = View.VISIBLE
                                score2.visibility = View.INVISIBLE


                            }
                            snake.translationX = snakeX
                        }
                    }

                    checkFoodCollision()
                    handler.postDelayed(this, delayMillis)
                }
            }

            handler.postDelayed(runnable, delayMillis)

// Set button onClickListeners to update the currentDirection variable when pressed
            upButton.setOnClickListener {
                currentDirection = "up"
            }
            downButton.setOnClickListener {
                currentDirection = "down"
            }
            leftButton.setOnClickListener {
                currentDirection = "left"
            }
            rightButton.setOnClickListener {
                currentDirection = "right"
            }
            playagain.setOnClickListener {

                recreate()
            }

        }

    }

}