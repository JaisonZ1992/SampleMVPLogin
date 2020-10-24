package com.example.loginmvpsample.model

import android.util.Patterns

class User(private var email: String, private var password: String) : IUser {

    override fun getEmail(): String {
        return email
    }

    override fun getPassword(): String {
        return password
    }

    override fun validateData(): Int {
        if (email.isEmpty()) {
            return 1
        } else if (isEmailInvalid(email)) {
            return 2
        } else if(password.isEmpty()){
            return 3
        } else if(password.length < 7){
            return 4
        }else
            return 5
    }

    private fun isEmailInvalid(email: CharSequence?): Boolean {
        return !Patterns.EMAIL_ADDRESS.matcher(email!!).matches()
    }
}