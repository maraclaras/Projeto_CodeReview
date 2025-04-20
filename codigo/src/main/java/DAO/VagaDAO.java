package DAO;

import java.io.Serializable;

import exceptions.VagaInvalidaException;

public class VagaDAO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String identificador;
    private boolean ocupada;
    private static int maxVagas;  // Número máximo de vagas permitido no estacionamento
    private static int vagasCriadas = 0;

    // Construtor para inicializar uma vaga com identificador alfanumérico
    public VagaDAO(String identificador, int maxVagasPermitidas) throws VagaInvalidaException {
        if (maxVagas == 0) {
            maxVagas = maxVagasPermitidas;
        }

        if (vagasCriadas >= maxVagas) {
            throw new VagaInvalidaException("Limite máximo de vagas atingido.");
        }

        if (!validarIdentificador(identificador)) {
            throw new VagaInvalidaException("Identificador de vaga inválido: " + identificador);
        }

        this.identificador = identificador;
        this.ocupada = false;
        vagasCriadas++;
    }

    private boolean validarIdentificador(String identificador) {
        return identificador.matches("[A-Z][0-9]{2}");
    }

    public void ocupar() throws VagaInvalidaException {
        if (ocupada) {
            throw new VagaInvalidaException("A vaga " + identificador + " já está ocupada.");
        }
        this.ocupada = true;
    }

    public void liberar() {
        this.ocupada = false;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public String getIdentificador() {
        return identificador;
    }

    public double calcularTaxa(double valorBase) {
        return valorBase;
    }

    @Override
    public String toString() {
        return "Vaga{" +
                "identificador='" + identificador + '\'' +
                ", ocupada=" + ocupada +
                '}';
    }
}