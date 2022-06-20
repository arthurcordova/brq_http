package com.mobwaysolutions.httpsample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobwaysolutions.httpsample.R
import com.mobwaysolutions.httpsample.RepositorioModel

class RepositorioAdapter : RecyclerView.Adapter<RepositorioViewHolder>() {

    private val baseList = mutableListOf<RepositorioModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositorioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_repositorio, parent, false)
        return RepositorioViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepositorioViewHolder, position: Int) {
        holder.bind(baseList[position])
    }

    override fun getItemCount(): Int = baseList.size

    fun refresh(newList: List<RepositorioModel>) {
        baseList.clear()
        baseList.addAll(newList)
        notifyDataSetChanged()
    }

}