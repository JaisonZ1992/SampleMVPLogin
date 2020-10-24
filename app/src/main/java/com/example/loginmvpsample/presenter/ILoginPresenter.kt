package com.example.loginmvpsample.presenter

interface ILoginPresenter {
    fun attemptLogin(email:String, password:String)
}