package com.studio.mattiaferigutti.mvcpattern.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.studio.mattiaferigutti.mvcpattern.R
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity(), ListView {

    private val presenter = ListPresenter(this, FindItemsInteractor())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun showProgress() {
        progress?.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress?.visibility = View.INVISIBLE
    }

    override fun onLoadedItems() {
        Toast.makeText(this, "Items loaded", Toast.LENGTH_SHORT).show()
    }

    override fun onFoundItems(items: List<String>) {
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = ListAdapter(this, list, this, items, presenter::onItemClicked)
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}