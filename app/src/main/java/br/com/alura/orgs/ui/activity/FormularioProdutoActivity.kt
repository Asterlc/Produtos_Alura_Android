package br.com.alura.orgs.ui.activity

import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs.R
import br.com.alura.orgs.dao.ProdutosDao
import br.com.alura.orgs.databinding.ActivityFormularioProdutoBinding
import br.com.alura.orgs.databinding.FormularioImagemBinding
import br.com.alura.orgs.databinding.ProdutoItemBinding
import br.com.alura.orgs.model.Produto
import coil.load
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {
    val TAG = "ProdutoActivity"
    private val dao = ProdutosDao()
    private val binding by lazy {
        ActivityFormularioProdutoBinding.inflate(layoutInflater)
    }
    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraBtnSalvar()
        setContentView(binding.root)
        binding.produtoImagem.setOnClickListener {
            val formularioImagemBinding = FormularioImagemBinding.inflate(layoutInflater)

            AlertDialog.Builder(this)
                .setView(formularioImagemBinding.root)
                .setPositiveButton("Confirmar", DialogInterface.OnClickListener { _, _ ->
                    formularioImagemBinding.formularioImagemBtnCarregar.setOnClickListener {
                        url = formularioImagemBinding.formularioImagemUrl.toString()
                        binding.produtoImagem.load(url)
                    }
                })
                .setNegativeButton("Cancelar", DialogInterface.OnClickListener { _, _ ->

                })
                .show()
        }
    }

    private fun configuraBtnSalvar() {
        val botaoSalvar = binding.BtnSalvar
        botaoSalvar.setOnClickListener {
            val produtoNovo = criarProduto()
            dao.adicionar(produtoNovo)
            finish()
        }
    }

    private fun criarProduto(): Produto{
        val nome = binding.activityFormularioEditTextNome.text.toString()
        val descricao = binding.activityFormularioEditTextDescricao.text.toString()
        val valor = validaValor(binding.activityFormularioEditTextValor.text.toString())
        val imagem = binding.produtoImagem.toString()

        return Produto(nome=nome, descricao=descricao, valor= valor, imagem=imagem)
    }

    private fun validaValor(valor: String): BigDecimal{
        return if(valor.isNullOrBlank()){
            BigDecimal.ZERO
        }else{
            BigDecimal(binding.activityFormularioEditTextValor.text.toString())
        }
    }

}