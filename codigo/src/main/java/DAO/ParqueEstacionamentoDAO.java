package DAO;

import java.util.ArrayList;

public class ParqueEstacionamentoDAO {
    private ArrayList<Cliente> clientes;
    private ArrayList<Vaga> vagas;

    public ParqueEstacionamentoDAO(ArrayList<Cliente> clientes, ArrayList<Vaga> vagas) {
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
