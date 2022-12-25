package br.com.alura.orgs.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import br.com.alura.orgs.R
import br.com.alura.orgs.model.Produto
import br.com.alura.orgs.model.ProdutosDao
import br.com.alura.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.math.BigDecimal

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dao = ProdutosDao()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ListaProdutosAdapter(
            context = this,
            produtos = dao.buscarTodos()
        )
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            startActivity(Intent(this, FormularioProdutoActivity::class.java))
        }
    }
}

//            produtos = listOf(
//                Produto(nome = "Teste1", descricao = "Teste desc1", valor = BigDecimal("19.99")),
//                Produto(nome = "Teste2", descricao = "Teste desc2", valor = BigDecimal("19.99")),
//                Produto(nome = "Teste3", descricao = "Teste desc3", valor = BigDecimal("19.99")),
//                Produto(nome = "Teste4", descricao = "Teste desc4", valor = BigDecimal("19.99")),
//            )
