package com.mobwaysolutions.httpsample

import android.view.View
import android.widget.ImageView
import com.squareup.picasso.Picasso

fun View.mostrar() {
    visibility = View.VISIBLE
}

fun View.esconder() {
    visibility = View.GONE
}

fun ImageView.loadFromUrl(url: String?) {
    Picasso.get().load(url).into(this)
}