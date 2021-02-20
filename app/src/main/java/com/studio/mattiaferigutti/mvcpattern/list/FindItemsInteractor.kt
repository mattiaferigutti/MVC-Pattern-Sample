package com.studio.mattiaferigutti.mvcpattern.list

import com.studio.mattiaferigutti.mvcpattern.postDelayed

class FindItemsInteractor {

    fun loadElements(callback: (List<String>) -> Unit) {
        postDelayed(2000L) {
            callback(loadElementsLocally())
        }
    }

    private fun loadElementsLocally(): List<String> = (0..10).map { "$it item" }
}