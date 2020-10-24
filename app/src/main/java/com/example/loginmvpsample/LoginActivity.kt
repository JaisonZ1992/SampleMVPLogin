package com.example.loginmvpsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.loginmvpsample.databinding.ActivityLoginBinding
import com.example.loginmvpsample.presenter.ILoginPresenter
import com.example.loginmvpsample.presenter.LoginPresenter
import com.example.loginmvpsample.view.ILoginView
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity(),ILoginView {

    private lateinit var presenter: ILoginPresenter
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPresenter()
        initViews()
    }

    override fun onLoginResult(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    private fun initPresenter() {
        presenter = LoginPresenter(this)
    }

    private fun initViews() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.buttonLogin.setOnClickListener { presenter.attemptLogin(binding.editTextTextEmailAddress.text.toString(),binding.editTextTextPassword.text.toString()) }
    }
}