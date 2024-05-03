package com.example.tcc1_abdiel

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SignInActivity : Activity() {

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

//        firebaseAuth.getInstance()

        val txtView = findViewById<TextView>(R.id.textView)
        val btn = findViewById<Button>(R.id.button)
        val edTextEmail = findViewById<EditText>(R.id.emailEt)
        val edtPassword = findViewById<EditText>(R.id.passET)

        txtView.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        btn.setOnClickListener {
            val email = edTextEmail.text.toString()
            val pass = edtPassword.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {

                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Senha e email não podem estar vazios", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

