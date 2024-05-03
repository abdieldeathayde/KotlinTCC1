package com.example.tcc1_abdiel

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : Activity() {

    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val edTextEmail = findViewById<EditText>(R.id.editTextEmailAddress)

        edTextEmail.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        val btn = findViewById<Button>(R.id.button)
        val password = findViewById<EditText>(R.id.editTextPassword)
        val confirmPassword = findViewById<EditText>(R.id.editTextConfirrmPassword)

        btn.setOnClickListener {
            val email = edTextEmail.text.toString()
            val pass = password.text.toString()
            val confirmPass = confirmPassword.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {
                if (pass == confirmPass) {
                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val intent = Intent(this, SignInActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, task.exception?.message, Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this, "As senhas não coincidem", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "O email e a senha não podem estar vazios", Toast.LENGTH_SHORT).show()
            }
        }



        // Encontre a ImageView com o ID imageView no layout
        val logoImageView = findViewById<ImageView>(R.id.imageView)

        // Defina a imagem da logo (substitua R.drawable.logo pelo ID da sua imagem)
        logoImageView.setImageResource(R.drawable.ifsc)
    }
}
