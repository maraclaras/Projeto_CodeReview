package DAO;

import java.util.ArrayList;

public class ParqueEstacionamentoDAO {
    private ArrayList<ClienteDAO> clientes;
    private ArrayList<Vaga> vagas;

    public ParqueEstacionamentoDAO(ArrayList<ClienteDAO> clientes, ArrayList<Vaga> vagas) {
        this.clientes = clientes;
        this.vagas = vagas;
    }

    public ArrayList<ClienteDAO> getClientes() {
        return clientes;
    }

    public ArrayList<Vaga> getVagas() {
        return vagas;
    }
}
