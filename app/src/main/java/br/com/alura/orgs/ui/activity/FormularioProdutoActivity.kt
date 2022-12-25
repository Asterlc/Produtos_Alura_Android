package br.com.alura.orgs.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs.R
import br.com.alura.orgs.model.Produto
import br.com.alura.orgs.model.ProdutosDao
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {
    val TAG = "ProdutoActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val botaoSalvar = findViewById<Button>(R.id.BtnSalvar)
        botaoSalvar.setOnClickListener {
            val campoNome = findViewById<EditText>(R.id.nome)
            val nome = campoNome.text.toString()
            val campoDescricao = findViewById<EditText>(R.id.descricao)
            val descricao = campoDescricao.text.toString()
            val campoValor = findViewById<EditText>(R.id.valor)
            val valorEmTexto = campoValor.text.toString()
            val valor = if(valorEmTexto.isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(valorEmTexto)
            }


            val produtoNovo = Produto(
                nome = nome,
                descricao = descricao,
                valor = valor
            )

            Log.i("FormularioProduto", "onCreate: $produtoNovo")
            val dao = ProdutosDao()
            dao.adicionar(produtoNovo)
            Log.i("FormularioProduto", "onCreate: ${dao.buscarTodos()}")
            finish()
        }
    }
}