package com.mobwaysolutions.httpsample.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mobwaysolutions.httpsample.R
import com.mobwaysolutions.httpsample.dto.Comment
import com.mobwaysolutions.httpsample.dto.UsuarioModel
import com.mobwaysolutions.httpsample.loadFromUrl

class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val ivAvatar = itemView.findViewById<ImageView>(R.id.ivAvatar)
    private val tvNome = itemView.findViewById<TextView>(R.id.tvNome)

    fun bind(model: Comment) {
        tvNome.text = model.body
//        ivAvatar.loadFromUrl(usuarioModel.photo)
    }

}
