package com.studio.mattiaferigutti.mvcpattern.main

import com.studio.mattiaferigutti.mvcpattern.postDelayed

class MainInteractor() {
    /**
     * this class represents the model
     */

    interface OnLoginEvent {
        fun onWrongPassword()
        fun onWrongUsername()
        fun onSuccessful()
    }

    fun login(username: String, password: String, listener: OnLoginEvent) {
        postDelayed(2000L) {
            when {
                username.isBlank() -> listener.onWrongUsername()
                password.isBlank() -> listener.onWrongPassword()
                else -> listener.onSuccessful()
            }
        }
    }
}