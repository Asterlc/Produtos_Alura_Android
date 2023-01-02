package br.com.alura.orgs.dao

import br.com.alura.orgs.R
import br.com.alura.orgs.model.Produto
import java.math.BigDecimal

class ProdutosDao {

    companion object {
        val produtos: MutableList<Produto> = mutableListOf<Produto>(
            Produto(
                nome = "Teste",
                descricao = "Teste",
                valor = BigDecimal("19.90"),
                imagem = R.drawable.imagem_padrao.toString()
            )
        )
    }

    fun adicionar(produto: Produto) {
        produtos.add(produto)
    }

    fun buscarTodos(): List<Produto> {
        return produtos.toList()
    }

}