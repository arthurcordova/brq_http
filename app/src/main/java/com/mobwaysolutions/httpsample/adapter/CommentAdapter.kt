package com.mobwaysolutions.httpsample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobwaysolutions.httpsample.R
import com.mobwaysolutions.httpsample.dto.Comment
import com.mobwaysolutions.httpsample.dto.UsuarioModel

class CommentAdapter : RecyclerView.Adapter<CommentViewHolder>() {

    private val baseList = mutableListOf<Comment>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_usuario, parent, false)
        return CommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bind(baseList[position])
    }

    override fun getItemCount(): Int = baseList.size

    fun refresh(newList: List<Comment>) {
        baseList.clear()
        baseList.addAll(newList)
        notifyDataSetChanged()
    }

}