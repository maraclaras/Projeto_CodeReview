package DAO;

import java.util.ArrayList;

public class ParqueEstacionamentoDAO {
    private ArrayList<ClienteDAO> clientes;
    private ArrayList<VagaDAO> vagas;

    public ParqueEstacionamentoDAO(ArrayList<ClienteDAO> clientes, ArrayList<VagaDAO> vagas) {
        this.clientes = clientes;
        this.vagas = vagas;
    }

    public ArrayList<ClienteDAO> getClientes() {
        return clientes;
    }

    public ArrayList<VagaDAO> getVagas() {
        return vagas;
    }
}
