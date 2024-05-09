package com.example.tcc1_abdiel

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
//import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.tcc1_abdiel.R.id.textView
import com.example.tcc1_abdiel.R.id.textViewInscricaoAluno
import com.google.firebase.auth.FirebaseAuth

class SignInActivity : Activity() {

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        firebaseAuth = FirebaseAuth.getInstance()

        val email = findViewById<EditText>(R.id.emailEt)
        val pass = findViewById<EditText>(R.id.passET)
//        val logoIFSC = findViewById<ImageView>(R.id.imageView)
        val texto = findViewById<TextView>(textViewInscricaoAluno)

        texto.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.button)?.setOnClickListener {
            val email1 = email.text.toString()
            val pass1 = pass.text.toString()

            if (email1.isNotEmpty() && pass1.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email1, pass1).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Erro ao fazer login: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Campos não podem ser nulos!", Toast.LENGTH_SHORT).show()
            }
        }
    }

//    override fun onStart() {
//        super.onStart()
//
//        if (firebaseAuth.currentUser != null) {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//        }
//    }
}
