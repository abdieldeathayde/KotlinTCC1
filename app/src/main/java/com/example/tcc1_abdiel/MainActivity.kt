package com.example.tcc1_abdiel

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Verifica se o usuário já fez login
        val isLoggedIn = checkIfUserIsLoggedIn()
        val isregistred = checkIfUserRegistred()

        if (isLoggedIn) {
            // Se o usuário já fez login, vá para a MainActivity
            startMainActivity()
        } else if (!isregistred) {
            startSignInActivity()
        } else {
            // Caso contrário, vá para a SignUpActivity
            startSignUpActivity()
        }
    }

    private fun checkIfUserRegistred(): Boolean {
        if (checkIfUserIsLoggedIn()) {
            return true
        } else {
            return false
        }
    }

    private fun checkIfUserIsLoggedIn(): Boolean {
        // Implemente a lógica para verificar se o usuário já fez login
        // Por exemplo, verifique se há um token de autenticação válido
        // ou se há informações de usuário na memória do aplicativo.
        // Retorne true se o usuário estiver logado e false caso contrário.
        // Substitua esta implementação pelo seu próprio código.
        return false
    }

    private fun startSignUpActivity() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
        finish() // Finaliza a MainActivity para que o usuário não possa voltar a ela
    }

    private fun startSignInActivity() {
        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
        finish() // Finaliza a MainActivity para que o usuário não possa voltar a ela
    }

    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Finaliza a SignUpActivity para que o usuário não possa voltar a ela
    }
}
