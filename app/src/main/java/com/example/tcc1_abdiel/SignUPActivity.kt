package com.example.tcc1_abdiel

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : Activity() {

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val emailEt = findViewById<EditText>(R.id.emailEt)
        val passEt = findViewById<EditText>(R.id.passET)
        val confirmPassEt = findViewById<EditText>(R.id.confirmPassEt)
        val imageView = findViewById<ImageView>(R.id.imageView)



        firebaseAuth = FirebaseAuth.getInstance()

        findViewById<TextView>(R.id.textView)?.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.button)?.setOnClickListener {
            val email = emailEt.text.toString()
            val pass = passEt.text.toString()
            val confirmPass = confirmPassEt.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {
                if (pass == confirmPass) {

                    firebaseAuth.createUserWithEmailAndPassword(email, pass)
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                                val intent = Intent(this, SignInActivity::class.java)
                                startActivity(intent)
                            } else {
                                Toast.makeText(
                                    this,
                                    it.exception.toString(),
                                    Toast.LENGTH_SHORT
                                ).show()

                            }
                        }
                } else {
                    Toast.makeText(this, "Senhas não são iguais", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Campos não podem estar vazios !!", Toast.LENGTH_SHORT).show()

            }
        }
    }
}