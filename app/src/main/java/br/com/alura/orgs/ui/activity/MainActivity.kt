package br.com.alura.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.model.ProdutosDao
import br.com.alura.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        val dao = ProdutosDao()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        Log.i(TAG, "onResume: ${dao.buscarTodos()}")
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

