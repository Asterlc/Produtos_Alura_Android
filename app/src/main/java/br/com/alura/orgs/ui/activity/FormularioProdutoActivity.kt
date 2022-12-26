package br.com.alura.orgs.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs.R
import br.com.alura.orgs.model.Produto
import br.com.alura.orgs.dao.ProdutosDao
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {
    val TAG = "ProdutoActivity"
    private val dao = ProdutosDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraBtnSalvar()
    }

    private fun configuraBtnSalvar() {
        val botaoSalvar = findViewById<Button>(R.id.BtnSalvar)
        botaoSalvar.setOnClickListener {
            val (nome, descricao, valor) = configuraCampos()
            val produtoNovo = configuraProduto(nome, descricao, valor)
            dao.adicionar(produtoNovo)
            finish()
        }
    }

    private fun configuraProduto(
        nome: String,
        descricao: String,
        valor: BigDecimal
    ): Produto {
        return Produto(
            nome = nome,
            descricao = descricao,
            valor = valor
        )
    }

    private fun configuraCampos(): Triple<String, String, BigDecimal> {
        val campoNome = findViewById<EditText>(R.id.nome)
        val nome = campoNome.text.toString()
        val campoDescricao = findViewById<EditText>(R.id.descricao)
        val descricao = campoDescricao.text.toString()
        val campoValor = findViewById<EditText>(R.id.valor)
        val valorEmTexto = campoValor.text.toString()
        val valor = if (valorEmTexto.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorEmTexto)
        }
        return Triple(nome, descricao, valor)
    }
}