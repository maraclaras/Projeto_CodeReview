package modal;

import exceptions.VagaInvalidaException;

public class PCD extends Vaga {
    private boolean espacoSuficiente;  // Verificação de espaço adequado para PCD

    public PCD(String identificador, int maxVagasPermitidas, boolean espacoSuficiente) throws VagaInvalidaException {
        super(identificador, maxVagasPermitidas); // Passa o identificador e o número máximo de vagas
        if (!espacoSuficiente) {
            throw new VagaInvalidaException("A vaga PCD precisa de espaço suficiente para manusear dispositivos como cadeira de rodas.");
        }
        this.espacoSuficiente = espacoSuficiente;
    }

    // Calcula a taxa aplicando 13% de desconto para PCD
    @Override
    public double calcularTaxa(double valorBase) {
        return valorBase * 0.87f;  // Aplica 13% de desconto
    }
}