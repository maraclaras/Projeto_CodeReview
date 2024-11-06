public class VIP extends Vaga {
    private double taxaVip;
    private static final double ADICIONAL = 0.20; // 20% de aumento por VIP
    private boolean coberta; // característica: se a vaga é coberta
    private boolean proximaPortao; // característica: se a vaga é próxima ao portão

    // Construtor da classe VIP
    public VIP(String identificador, double taxaVip, boolean coberta, boolean proximaPortao, int maxVagasPermitidas) throws VagaInvalidaException {
        super(identificador, maxVagasPermitidas); // Passando o identificador e o número máximo de vagas
        this.taxaVip = taxaVip;
        this.coberta = coberta;
        this.proximaPortao = proximaPortao;
    }

    // Método para calcular a taxa de estacionamento
    @Override
    public double calcularTaxa(double valorBase) {
        return valorBase * (1 + ADICIONAL); // Aplica o aumento de 20%
    }

    public boolean isCoberta() {
        return coberta;
    }

    public boolean isProximaPortao() {
        return proximaPortao;
    }
}
