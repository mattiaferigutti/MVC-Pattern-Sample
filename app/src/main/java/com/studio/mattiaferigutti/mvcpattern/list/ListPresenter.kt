package com.studio.mattiaferigutti.mvcpattern.list

class ListPresenter(private var listView: ListView?, private val findItemsInteractor: FindItemsInteractor?) {

    fun onResume() {
        listView?.showProgress()
        findItemsInteractor?.loadElements(::onItemLoaded)
    }

    private fun onItemLoaded(items: List<String>) {
        listView?.apply {
            onFoundItems(items)
        }
    }

    fun onItemClicked(item: String) {
        listView?.showMessage(item)
    }

    fun onDestroy() {
        listView = null
    }
}