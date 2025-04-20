package DTO;

public class VagaDTO {
    private String identificador;
    private boolean ocupada;
    private boolean pcd; // Indica se a vaga é destinada a PCD

    public VagaDTO(String identificador, boolean pcd) {
        this.identificador = identificador;
        this.ocupada = false;
        this.pcd = pcd;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public boolean isPcd() {
        return pcd;
    }

    public void setPcd(boolean pcd) {
        this.pcd = pcd;
    }

    @Override
    public String toString() {
        return "VagaDTO{" +
                "identificador='" + identificador + '\'' +
                ", ocupada=" + ocupada +
                ", pcd=" + pcd +
                '}';
    }
}