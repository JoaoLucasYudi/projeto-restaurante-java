package br.com.restaurante.estoque.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import br.com.restaurante.estoque.exception.EstoqueException;

public class EstoqueService {

    private Map<String, Produto> produtos = new HashMap<>();

    public void registrarEntradaProduto(Produto produto, int quantidade, String fornecedor, LocalDate dataEntrada) throws EstoqueException {
        if (quantidade <= 0) {
            throw new EstoqueException("Quantidade de entrada deve ser maior que zero.");
        }
        produto.setQuantidade(produto.getQuantidade() + quantidade);
        produtos.put(produto.getNome(), produto);
        System.out.println("Entrada registrada: " + quantidade + " unidades de " + produto.getNome());
    }

    public void registrarSaidaProduto(Produto produto, int quantidade, LocalDate dataSaida) throws EstoqueException {
        if (produto.getQuantidade() < quantidade) {
            throw new EstoqueException("Estoque insuficiente para o produto: " + produto.getNome());
        }
        produto.setQuantidade(produto.getQuantidade() - quantidade);
        produtos.put(produto.getNome(), produto);
        System.out.println("Saida registrada: " + quantidade + " unidades de " + produto.getNome());
    }

    public int consultarSaldoProduto(Produto produto) {
        return produtos.getOrDefault(produto.getNome(), produto).getQuantidade();
    }

    public void gerarRelatorioEstoque() {
        System.out.println("Relatorio de Estoque:");
        for (Produto produto : produtos.values()) {
            System.out.println("Produto: " + produto.getNome() + ", Quantidade: " + produto.getQuantidade() + ", Valor Total: " + (produto.getQuantidade() * produto.getPreco()));
        }
    }
}