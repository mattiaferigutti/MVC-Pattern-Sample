package com.studio.mattiaferigutti.mvcpattern.main

interface MainView {
    fun showProgress()
    fun hideProgress()
    fun setUsernameError()
    fun setPasswordError()
    fun navigateToHome()
}