package br.com.restaurante.estoque.exception;

/**
 * EstoqueException é uma checked exception que representa erros específicos 
 * relacionados ao gerenciamento de estoque.
 * Esta exceção deve ser tratada ou propagada explicitamente.
 */
public class EstoqueException extends Exception {
    
    private static final long serialVersionUID = 1L;

    public EstoqueException(String message) {
        super(message);
    }

    public EstoqueException(String message, Throwable cause) {
        super(message, cause);
    }
}
