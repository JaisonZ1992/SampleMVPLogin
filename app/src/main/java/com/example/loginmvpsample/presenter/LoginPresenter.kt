package com.example.loginmvpsample.presenter

import com.example.loginmvpsample.model.User
import com.example.loginmvpsample.view.ILoginView

class LoginPresenter(private var loginView: ILoginView) : ILoginPresenter{

    private lateinit var user:User

    override fun attemptLogin(email: String, password: String){
        user = User(email,password)
        return loginView.onLoginResult(sendResponseToLogin())
    }

    private fun sendResponseToLogin(): String {
        when (user.validateData()) {
            1 -> return ("Email is required")
            2 -> return ("Email pattern is invalid")
            3 -> return ("Password is required")
            4 -> return ("Password should have minimum 7 characters")
            else -> {
                return ("Login Success")
            }
        }
    }


}