package br.com.alura.orgs.dialog

import android.content.Context
import android.content.DialogInterface
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import br.com.alura.orgs.databinding.FormularioImagemBinding
import coil.load

class FormularioImagemDialog(private val context: Context) {
    val TAG = "FormularioImagemDialog"

    fun show(quandoCarregar: (imagemURL: String) -> Unit) {
        val binding = FormularioImagemBinding.inflate(LayoutInflater.from(context))
        binding.formularioImagemBtnCarregar.setOnClickListener {
            val url = binding.formularioImagemUrl.text.toString()
            Log.i(TAG, "Imagem carregada: ${url}")
            binding.formularioImagemImageView.load(url)
        }
        AlertDialog.Builder(context)
            .setView(binding.root)
            .setPositiveButton("Confirmar", DialogInterface.OnClickListener { _, _ ->
                val url = binding.formularioImagemUrl.text.toString()
                Log.i(TAG, "Imagem Para formulario: $url")
                quandoCarregar(url)
            })
            .setNegativeButton("Cancelar", DialogInterface.OnClickListener { _, _ ->

            })
            .show()
    }
}