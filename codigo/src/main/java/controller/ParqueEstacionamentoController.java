package controller;

import exceptions.VagaInvalidaException;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import DAO.ClienteDAO;
import DAO.VagaDAO;
import DTO.ParqueEstacionamentoDAO;
import DTO.VeiculoDTO;

public class ParqueEstacionamentoController {
    private ParqueEstacionamentoDAO parqueEstacionamento;

    // Construtor que inicializa o ParqueEstacionamento
    public ParqueEstacionamentoController(int numFilas, int numVagasPorFila) {
        this.parqueEstacionamento = ParqueEstacionamentoDAO.getInstancia(numFilas, numVagasPorFila);
    }

    public void registrarCliente(ClienteDAO cliente) {
        ParqueEstacionamentoDAO.registrarCliente(cliente);
    }

    public ClienteDAO buscarClientePorCpf(String cpf) {
        return ParqueEstacionamentoDAO.buscarClientePorCpf(cpf);
    }

    public VagaDAO liberarVaga(String identificador, LocalDateTime saida) throws VagaInvalidaException {
        return parqueEstacionamento.liberarVaga(identificador, saida);
    }

    public void estacionarClienteNaVaga(String identificador, VeiculoDTO veiculo, LocalDateTime entrada) throws VagaInvalidaException {
        parqueEstacionamento.estacionarVeiculo(parqueEstacionamento.obterVagaPorIdentificador(identificador), veiculo, entrada);
    }

    public VagaDAO obterVagaPorVeiculo(VeiculoDTO veiculo) {
        return parqueEstacionamento.obterVagaPorVeiculo(veiculo);
    }

    public ArrayList<ClienteDAO> listarClientes() {
        return parqueEstacionamento.listarClientes();
    }

    public void salvarDados(String caminhoArquivo) throws IOException {
        parqueEstacionamento.salvarDados(caminhoArquivo);
    }

    public void carregarDados(String caminhoArquivo) throws IOException, ClassNotFoundException {
        this.parqueEstacionamento = ParqueEstacionamentoDAO.carregarDados(caminhoArquivo);
    }
}