package com.mobwaysolutions.httpsample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobwaysolutions.httpsample.R
import com.mobwaysolutions.httpsample.UsuarioModel

class UsuarioAdapter : RecyclerView.Adapter<UsuarioViewHolder>() {

    private val baseList = mutableListOf<UsuarioModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_usuario, parent, false)
        return UsuarioViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        holder.bind(baseList[position])
    }

    override fun getItemCount(): Int = baseList.size

    fun refresh(newList: List<UsuarioModel>) {
        baseList.clear()
        baseList.addAll(newList)
        notifyDataSetChanged()
    }

}