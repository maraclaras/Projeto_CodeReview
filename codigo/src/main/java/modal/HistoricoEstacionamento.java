package modal;

import java.time.LocalDateTime;

public class HistoricoEstacionamento {
    private Long id; // Identificador único do histórico
    private String identificadorVaga;
    private String cpfCliente;
    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;

    // Construtor
    public HistoricoEstacionamento(Long id, String identificadorVaga, String cpfCliente, LocalDateTime dataEntrada) {
        this.id = id;
        this.identificadorVaga = identificadorVaga;
        this.cpfCliente = cpfCliente;
        this.dataEntrada = dataEntrada;
        this.dataSaida = null;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificadorVaga() {
        return identificadorVaga;
    }

    public void setIdentificadorVaga(String identificadorVaga) {
        this.identificadorVaga = identificadorVaga;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDateTime getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDateTime dataSaida) {
        this.dataSaida = dataSaida;
    }

    @Override
    public String toString() {
        return "Histórico de Estacionamento {" +
                "ID=" + id +
                ", Vaga='" + identificadorVaga + '\'' +
                ", CPF Cliente='" + cpfCliente + '\'' +
                ", Entrada=" + dataEntrada +
                ", Saída=" + (dataSaida != null ? dataSaida : "Ainda estacionado") +
                '}';
    }
}
