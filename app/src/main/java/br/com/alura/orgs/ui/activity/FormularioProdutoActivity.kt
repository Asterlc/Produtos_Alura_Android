package br.com.alura.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs.R
import br.com.alura.orgs.model.Produto
import br.com.alura.orgs.model.ProdutosDao
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        val botao_salvar = findViewById<Button>(R.id.BtnSalvar)
        botao_salvar.setOnClickListener {
            val campoNome = findViewById<EditText>(R.id.nome).text.toString()
            Log.i("FormularioProduto", "OnCreate: $campoNome")
            val campoDesc = findViewById<EditText>(R.id.descricao).text.toString()
            Log.i("FormularioProduto", "OnCreate: $campoDesc")
            val valor = findViewById<EditText>(R.id.valor).text.toString()
            val campoValor = if (valor.isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(findViewById<EditText>(R.id.valor).text.toString())
            }
            Log.i("FormularioProduto", "OnCreate: $campoValor")
            val produto = Produto(nome = campoNome, descricao = campoDesc, valor = campoValor)
            val dao = ProdutosDao()
            dao.adicionar(produto)
            dao.buscarTodos()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}