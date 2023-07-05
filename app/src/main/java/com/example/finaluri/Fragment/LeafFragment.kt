package com.example.finaluri.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.finaluri.C
import com.example.finaluri.FlappyBird
import com.example.finaluri.Iron
import com.example.finaluri.R

class LeafFragment:Fragment(R.layout.fragment_leaf) {

    private lateinit var flappy: Button
    private lateinit var tictactoe: Button
    private lateinit var snake: Button

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


        }

        snake.setOnClickListener {


        }
    }
}
