package dto;

import java.util.ArrayList;
import modal.Cliente;
import modal.Vaga;

public class ParqueEstacionamentoDto {
    private ArrayList<Cliente> clientes;
    private ArrayList<Vaga> vagas;

    public ParqueEstacionamentoDto(ArrayList<Cliente> clientes, ArrayList<Vaga> vagas) {
        this.clientes = clientes;
        this.vagas = vagas;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Vaga> getVagas() {
        return vagas;
    }
}
