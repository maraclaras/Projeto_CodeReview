package DTO;

public class CobrancaDTO {
    private String cpfCliente;
    private double valorCobrado;
    private int minutosEstacionados;

    public CobrancaDTO(String cpfCliente, double valorCobrado, int minutosEstacionados) {
        this.cpfCliente = cpfCliente;
        this.valorCobrado = valorCobrado;
        this.minutosEstacionados = minutosEstacionados;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public double getValorCobrado() {
        return valorCobrado;
    }

    public void setValorCobrado(double valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    public int getMinutosEstacionados() {
        return minutosEstacionados;
    }

    public void setMinutosEstacionados(int minutosEstacionados) {
        this.minutosEstacionados = minutosEstacionados;
    }
}