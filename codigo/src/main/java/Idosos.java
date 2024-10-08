public class Idosos extends Vaga {
    private static final double DESCONTO = 0.15; // 15% de desconto para idosos
    private double taxaBase; // Taxa base a ser aplicada

    // Construtor da classe Idosos
    public Idosos(String identificador, double taxaBase) throws VagaInvalidaException {	
        super(identificador, 1); // Chama o construtor da superclasse com um identificador e 1 como número máximo de vagas
        this.taxaBase = taxaBase; // Inicializa a taxa base
    }

    // Método para calcular a taxa com desconto
    @Override
    public double calcularTaxa(float valorBase) {
        return this.taxaBase * (1 - DESCONTO);
    }
}    
