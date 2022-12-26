package br.com.alura.orgs.dao

import br.com.alura.orgs.model.Produto

class ProdutosDao {

    companion object {
        val produtos: MutableList<Produto> = mutableListOf<Produto>()
    }

    fun adicionar(produto: Produto) {
        produtos.add(produto)
    }

    fun buscarTodos(): List<Produto> {
        return produtos.toList()
    }

}