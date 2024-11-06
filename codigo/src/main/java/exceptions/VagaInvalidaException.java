package exceptions;

public class VagaInvalidaException extends Exception { // Extende Exception
    // Construtor padrão
    public VagaInvalidaException() {
        super("Vaga inválida."); // Mensagem padrão
    }

    // Construtor que aceita uma mensagem personalizada
    public VagaInvalidaException(String message) {
        super(message); // Passa a mensagem para o construtor da superclasse
    }
}
