package br.com.alura.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs.R
import br.com.alura.orgs.dao.ProdutosDao
import br.com.alura.orgs.databinding.ActivityMainBinding
import br.com.alura.orgs.ui.recyclerview.adapter.ListaProdutosAdapter

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val TAG = "MainActivity"
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val dao = ProdutosDao()
    private val adapter = ListaProdutosAdapter(
        context = this,
        dataSet = dao.buscarTodos()
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraRecyclerView()
        configuraFAB()
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscarTodos())
    }

    private fun configuraFAB() {
//        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        val fab = binding.floatingActionButton
        fab.setOnClickListener {
            startActivity(Intent(this, FormularioProdutoActivity::class.java))
        }
    }

    private fun configuraRecyclerView() {
//        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        Log.i(TAG, "onResume: ${dao.buscarTodos()}")
    }
}

