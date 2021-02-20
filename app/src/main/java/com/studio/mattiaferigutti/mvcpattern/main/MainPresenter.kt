package com.studio.mattiaferigutti.mvcpattern.main

/**
 * Let's respect the dependency injection
 */
class MainPresenter(private var mainView: MainView?, private val mainInteractor: MainInteractor?) :
    MainInteractor.OnLoginEvent {

    fun makeLogin(username: String, password: String) {
        mainView?.showProgress()
        mainInteractor?.login(username, password, this)
    }

    override fun onWrongPassword() {
        mainView?.apply {
            setPasswordError()
            hideProgress()
        }
    }

    override fun onWrongUsername() {
        mainView?.apply {
            setUsernameError()
            hideProgress()
        }
    }

    override fun onSuccessful() {
        mainView?.apply {
            navigateToHome()
            hideProgress()
        }
    }

    fun onDestroy() {
        mainView = null
    }
}