package controller;

import DAO.CobrancaDAO;
import DAO.ClienteDAO;
import DAO.VagaDAO;
import DTO.CobrancaDTO;
import exceptions.HorarioInvalidoException;

public class CobrancaController {
    private static final float TAXA_POR_MINUTO = 4.0f;
    private static final float MAX_COBRANCA = 50.0f;
    private CobrancaDAO cobrancaDAO;

    public CobrancaController(CobrancaDAO cobrancaDAO) {
        this.cobrancaDAO = cobrancaDAO;
    }

    public double calcularValor(int minutosEstacionados, VagaDAO vaga) {
        double valorBase = minutosEstacionados * TAXA_POR_MINUTO;
        if (valorBase > MAX_COBRANCA) {
            valorBase = MAX_COBRANCA;
        }
        return valorBase;
    }

    public int calcularMinutos(int horaInicio, int horaFinal) {
        int minutosTotal = horaFinal - horaInicio;
        return minutosTotal;
    }

    public void registrarCobranca(String cpf, int minutosEstacionados, VagaDAO vaga) {
        double valorCobrado = calcularValor(minutosEstacionados, vaga);
        CobrancaDTO cobranca = new CobrancaDTO(cpf, valorCobrado, minutosEstacionados);
        cobrancaDAO.registrarCobranca(cobranca);
        System.out.println("Cobrança registrada para o cliente com CPF " + cpf + ": R$ " + valorCobrado);
    }
}