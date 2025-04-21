package DAO;

import DTO.CobrancaDTO;
import java.util.ArrayList;
import java.util.List;

public class CobrancaDAO {
    private List<CobrancaDTO> cobrancas;

    public CobrancaDAO() {
        this.cobrancas = new ArrayList<>();
    }

    public void registrarCobranca(CobrancaDTO cobranca) {
        cobrancas.add(cobranca);
    }

    public List<CobrancaDTO> listarCobrancas() {
        return new ArrayList<>(cobrancas);
    }
}