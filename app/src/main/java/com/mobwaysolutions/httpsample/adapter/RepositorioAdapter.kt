package com.mobwaysolutions.httpsample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobwaysolutions.httpsample.R
import com.mobwaysolutions.httpsample.dto.RepositorioModel

class RepositorioAdapter(private val onClick: (RepositorioModel) -> Unit) :
    RecyclerView.Adapter<RepositorioViewHolder>() {

    private val baseList = mutableListOf<RepositorioModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositorioViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_repositorio, parent, false)
        return RepositorioViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepositorioViewHolder, position: Int) {
        baseList[position].let { model ->
            holder.bind(model)
            holder.itemView.setOnClickListener { onClick.invoke(model) }
        }
    }

    override fun getItemCount(): Int = baseList.size

    fun refresh(newList: List<RepositorioModel>) {
        baseList.clear()
        baseList.addAll(newList)
        notifyDataSetChanged()
    }

}