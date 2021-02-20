package com.studio.mattiaferigutti.mvcpattern.list

interface ListView {
    fun showProgress()
    fun hideProgress()
    fun onLoadedItems()
    fun onFoundItems(items: List<String>)
    fun showMessage(message: String)
}