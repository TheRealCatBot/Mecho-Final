package com.example.finaluri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.finaluri.R
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

    private lateinit var SignInEmail: EditText
    private lateinit var SignInPassword: EditText
    private lateinit var buttonLogin: Button
    private lateinit var buttonRegister: Button

    private lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth= FirebaseAuth.getInstance()

        SignInEmail=findViewById(R.id.SignInEmail)
        SignInPassword=findViewById(R.id.SignInPassword)
        buttonLogin=findViewById(R.id.buttonLogin)
        buttonRegister=findViewById(R.id.buttonRegister)



        buttonLogin.setOnClickListener {
            val email=SignInEmail.text.toString()
            val password=SignInPassword.text.toString()

            if (email.isEmpty()||password.isEmpty()){
                Toast.makeText(this,"empty",Toast.LENGTH_SHORT).show()
            }else{
                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
                    if (it.isSuccessful){
                        startActivity(Intent(this,PersonActivity::class.java))
                        finish()
                    }else{
                        Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
                    }
                }

            }

        }
        buttonRegister.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))

        }

    }
}