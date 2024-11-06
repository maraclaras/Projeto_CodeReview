package dto;

public class VeiculoDto {
    private String placa;
    private String modelo;
    private String proprietarioNome;

    public VeiculoDto(String placa, String modelo, String proprietarioNome) {
        this.placa = placa;
        this.modelo = modelo;
        this.proprietarioNome = proprietarioNome;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getProprietarioNome() {
        return proprietarioNome;
    }

    public void setProprietarioNome(String proprietarioNome) {
        this.proprietarioNome = proprietarioNome;
    }
}
