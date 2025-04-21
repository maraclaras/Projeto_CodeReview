package DTO;

import java.util.List;

public class ParqueEstacionamentoDTO {
    private List<ClienteDTO> clientes;
    private List<VagaDTO> vagas;

    public ParqueEstacionamentoDTO(List<ClienteDTO> clientes, List<VagaDTO> vagas) {
        this.clientes = clientes;
        this.vagas = vagas;
    }

    public List<ClienteDTO> getClientes() {
        return clientes;
    }

    public void setClientes(List<ClienteDTO> clientes) {
        this.clientes = clientes;
    }

    public List<VagaDTO> getVagas() {
        return vagas;
    }

    public void setVagas(List<VagaDTO> vagas) {
        this.vagas = vagas;
    }
}