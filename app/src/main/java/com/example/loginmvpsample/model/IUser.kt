package com.example.loginmvpsample.model

interface IUser {
    fun getEmail():String
    fun getPassword():String
    fun validateData():Int
}