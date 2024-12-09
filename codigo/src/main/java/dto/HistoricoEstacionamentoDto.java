package dto;

import java.time.LocalDateTime;

public class HistoricoEstacionamentoDto {
    private Long id;
    private String identificadorVaga;
    private String cpfCliente;
    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;

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
}
