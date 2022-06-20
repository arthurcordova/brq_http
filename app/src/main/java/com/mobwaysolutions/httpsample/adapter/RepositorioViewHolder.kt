package com.mobwaysolutions.httpsample.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mobwaysolutions.httpsample.R
import com.mobwaysolutions.httpsample.RepositorioModel

class RepositorioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val tvId = itemView.findViewById<TextView>(R.id.tvId)
    private val tvFullName = itemView.findViewById<TextView>(R.id.tvFullName)

    fun bind(repositorioModel: RepositorioModel) {
        tvId.text = repositorioModel.id.toString()
        tvFullName.text = repositorioModel.nomeCompleto
    }

}