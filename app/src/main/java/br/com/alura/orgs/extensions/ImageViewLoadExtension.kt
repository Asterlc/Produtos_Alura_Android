package br.com.alura.orgs.extensions

import android.util.Log
import android.widget.ImageView
import br.com.alura.orgs.R
import coil.load

val TAG = "Extension"

fun ImageView.tryLoad(url: String? = null){
    Log.i(TAG, "tryload: $url")
    load(url){
        fallback(R.drawable.imagem_padrao)
        error(R.drawable.imagem_padrao)
        placeholder(R.drawable.placeholder)
    }
}