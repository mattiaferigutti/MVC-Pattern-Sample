package com.studio.mattiaferigutti.mvcpattern.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.studio.mattiaferigutti.mvcpattern.list.ListActivity
import com.studio.mattiaferigutti.mvcpattern.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.progress

class MainActivity : AppCompatActivity(), MainView {

    private val presenter = MainPresenter(this, MainInteractor())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            presenter.makeLogin(editUsername.text.toString(), editTextTextPassword.text.toString())
        }
    }

    override fun showProgress() {
        progress?.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress?.visibility = View.INVISIBLE
    }

    override fun setUsernameError() {
        Toast.makeText(this, "Empty username", Toast.LENGTH_SHORT).show()
    }

    override fun setPasswordError() {
        Toast.makeText(this, "Empty password", Toast.LENGTH_SHORT).show()
    }

    override fun navigateToHome() {
        startActivity(Intent(this, ListActivity::class.java))
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}