package com.example.finaluri.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.finaluri.*

class LeafFragment:Fragment(R.layout.fragment_leaf) {

    private lateinit var flappy: ImageButton
    private lateinit var tictactoe: ImageButton
    private lateinit var snake: ImageButton

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        flappy = view.findViewById(R.id.flappy)
        tictactoe = view.findViewById(R.id.tictactoe)
        snake = view.findViewById(R.id.snake)

        flappy.setOnClickListener {
            val intent = Intent(getActivity(), FlappyBird::class.java)
            getActivity()?.startActivity(intent)
        }

        tictactoe.setOnClickListener {
            val intent = Intent(getActivity(), TicTacToe::class.java)
            getActivity()?.startActivity(intent)

        }

        snake.setOnClickListener {
            val intent = Intent(getActivity(), Snake::class.java)
            getActivity()?.startActivity(intent)
        }
    }
}
