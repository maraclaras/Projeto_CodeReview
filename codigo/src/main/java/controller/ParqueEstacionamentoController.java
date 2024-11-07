package controller;

import modal.ParqueEstacionamento;
import modal.Vaga;
import modal.Cliente;
import modal.Veiculo;
import exceptions.VagaInvalidaException;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ParqueEstacionamentoController {
    private ParqueEstacionamento parqueEstacionamento;

    public ParqueEstacionamentoController(int numFilas, int numVagasPorFila) {
        this.parqueEstacionamento = new ParqueEstacionamento(numFilas, numVagasPorFila);
    }

    public ParqueEstacionamento getParqueEstacionamento() {
        return parqueEstacionamento;
    }

    public void registrarCliente(Cliente cliente) {
        parqueEstacionamento.registrarCliente(cliente);
    }

    public Cliente buscarClientePorCpf(String cpf) {
        return parqueEstacionamento.buscarClientePorCpf(cpf);
    }

    public Vaga liberarVaga(String identificador, LocalDateTime saida) throws VagaInvalidaException {
        Vaga vaga = parqueEstacionamento.obterVagaPorIdentificador(identificador);
        if (vaga != null && vaga.isOcupada()) {
            parqueEstacionamento.liberarVaga(vaga, saida);
            return vaga;
        } else {
            throw new VagaInvalidaException("A vaga já está livre ou não foi encontrada.");
        }
    }

    public void estacionarClienteNaVaga(String identificador, Veiculo veiculo, LocalDateTime entrada) throws VagaInvalidaException {
        Vaga vaga = parqueEstacionamento.obterVagaPorIdentificador(identificador);
        if (vaga != null && !vaga.isOcupada()) {
            parqueEstacionamento.estacionarVeiculo(vaga, veiculo, entrada);
            System.out.println("Vaga " + identificador + " ocupada.");
        } else {
            throw new VagaInvalidaException("A vaga já está ocupada ou não foi encontrada.");
        }
    }

    public Vaga obterVagaPorVeiculo(Veiculo veiculo) {
        return parqueEstacionamento.obterVagaPorVeiculo(veiculo);
    }

    public ArrayList<Cliente> listarClientes() {
        return parqueEstacionamento.listarClientes();
    }

    public void salvarDados(String caminhoArquivo) throws IOException {
        parqueEstacionamento.salvarDados(caminhoArquivo);
    }

    public void carregarDados(String caminhoArquivo) throws IOException, ClassNotFoundException {
        this.parqueEstacionamento = ParqueEstacionamento.carregarDados(caminhoArquivo);
    }
}