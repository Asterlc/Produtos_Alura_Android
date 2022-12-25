package br.com.alura.orgs.model

class ProdutosDao {

    val produtos: MutableList<Produto> = mutableListOf<Produto>()

    fun adicionar(produto: Produto){
        produtos.add(produto)
    }

    fun buscarTodos(): List<Produto>{
        return produtos.toList()
    }

}