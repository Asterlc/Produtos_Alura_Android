package br.com.alura.orgs.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.databinding.ProdutoItemBinding
import br.com.alura.orgs.model.Produto

class ListaProdutosAdapter(
    private val context: Context,
    dataSet: List<Produto>
) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    private val produtos = dataSet.toMutableList()

    class ViewHolder(binding: ProdutoItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val nomeDoProduto = binding.nome
        private val descricaoDoProduto = binding.descricao
        private val valorDoProduto = binding.valor

        fun linkItem(produto: Produto) {
            nomeDoProduto.text = produto.nome
            descricaoDoProduto.text = produto.descricao
            valorDoProduto.text = produto.valor.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProdutoItemBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )

//        return ViewHolder(
//            LayoutInflater.from(context).inflate(R.layout.produto_item, parent, false)
//        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.linkItem(produtos[position])
    }

    override fun getItemCount(): Int = produtos.size

    fun atualiza(produtos: List<Produto>) {
        this.produtos.clear()
        this.produtos.addAll(produtos)
    }
}
