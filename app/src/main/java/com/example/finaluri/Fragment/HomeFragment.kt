package com.example.finaluri.Fragment

import androidx.fragment.app.Fragment
import com.example.finaluri.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.example.finaluri.MainActivity
import com.example.finaluri.PasswordChangeActivity
import com.example.finaluri.TicTacToe
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import org.w3c.dom.Text


class HomeFragment :Fragment(R.layout.fragment_home) {

    private lateinit var paswordChanngeButton: Button
    private lateinit var logoutButton: Button
    private lateinit var flappy: TextView
    private lateinit var ticTacToe: TextView

    private lateinit var mAuth: FirebaseAuth
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        paswordChanngeButton =view.findViewById(R.id.gotoPasswordChangeButton)
        logoutButton =view.findViewById(R.id.logoutButton)

        mAuth = FirebaseAuth.getInstance()

        val auth = FirebaseAuth.getInstance()
        val db = FirebaseDatabase.getInstance().getReference("User")





        paswordChanngeButton.setOnClickListener {
            val intent = Intent (getActivity(), PasswordChangeActivity::class.java)
            getActivity()?.startActivity(intent)
        }

        logoutButton.setOnClickListener {
            mAuth.signOut()
            val intent = Intent (getActivity(), MainActivity::class.java)
            getActivity()?.startActivity(intent)
        }
    }
}