package com.mobwaysolutions.httpsample.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mobwaysolutions.httpsample.R
import com.mobwaysolutions.httpsample.RepositorioModel
import com.mobwaysolutions.httpsample.UsuarioModel
import com.squareup.picasso.Picasso

class UsuarioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val ivAvatar = itemView.findViewById<ImageView>(R.id.ivAvatar)
    private val tvNome = itemView.findViewById<TextView>(R.id.tvNome)

    fun bind(usuarioModel: UsuarioModel) {
        tvNome.text = usuarioModel.nome
        ivAvatar.loadFromUrl(usuarioModel.photo)
    }

}

fun ImageView.loadFromUrl(url: String?) {
    Picasso.get().load(url).into(this)
}