package br.com.restaurante.estoque.test;

import br.com.restaurante.estoque.exception.EstoqueException;
import br.com.restaurante.estoque.model.EstoqueService;
import br.com.restaurante.estoque.model.Produto;

import java.time.LocalDate;

public class EstoqueServiceTest {

    public static void main(String[] args) {
        EstoqueService estoqueService = new EstoqueService();

        Produto produto1 = new Produto("Arroz", 10, 5.0);
        Produto produto2 = new Produto("Feijao", 20, 7.0);

        try {
            // Registrar entrada de produto
            estoqueService.registrarEntradaProduto(produto1, 15, "Fornecedor A", LocalDate.now());

            // Registrar saída de produto
            estoqueService.registrarSaidaProduto(produto2, 2, LocalDate.now());

            // Consultar saldo de produto
            int saldoArroz = estoqueService.consultarSaldoProduto(produto1);
            System.out.println("Saldo do produto Arroz: " + saldoArroz);

            // Gerar relatório de estoque
            estoqueService.gerarRelatorioEstoque();

        } catch (EstoqueException e) {
            // Tratamento da checked exception
            System.err.println("Erro no gerenciamento de estoque: " + e.getMessage());
        }
    }
}
