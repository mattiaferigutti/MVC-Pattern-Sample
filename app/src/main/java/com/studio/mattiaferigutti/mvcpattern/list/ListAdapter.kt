package com.studio.mattiaferigutti.mvcpattern.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.studio.mattiaferigutti.mvcpattern.R

class ListAdapter(
    listView: ListView?,
    recyclerView: RecyclerView?,
    private val context: Context,
    private val list: List<String>,
    private val listener: (String) -> Unit
) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    init {
        recyclerView?.layoutManager = object : LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false) {
                override fun onLayoutCompleted(state:RecyclerView.State) {
                    super.onLayoutCompleted(state)
                    listView?.apply {
                        hideProgress()
                        onLoadedItems()
                    }
                }
            }
    }

    inner class ListViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_layout, parent, false) as TextView
        return ListViewHolder(v)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = list[position]
        holder.textView.text = item
        holder.textView.setOnClickListener { listener(item) }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}