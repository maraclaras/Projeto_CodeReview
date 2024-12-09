package DAO;

public class VagaDAO {
    private String identificador;
    private boolean ocupada;

    public VagaDAO(String identificador, boolean ocupada) {
        this.identificador = identificador;
        this.ocupada = ocupada;
    }

    public String getIdentificador() {
        return identificador;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    @Override
    public String toString() {
        return "Vaga " + identificador + " - " + (ocupada ? "Ocupada" : "Livre");
    }
}
