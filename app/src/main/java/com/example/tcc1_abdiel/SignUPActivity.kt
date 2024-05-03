package com.example.tcc1_abdiel

import android.app.Activity
import android.os.Bundle
import android.widget.ImageView

class SignUpActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // Encontre a ImageView com o ID imageView no layout
        val logoImageView = findViewById<ImageView>(R.id.imageView)

        // Defina a imagem da logo (substitua R.drawable.logo pelo ID da sua imagem)
        logoImageView.setImageResource(R.drawable.ifsc)
    }
}
