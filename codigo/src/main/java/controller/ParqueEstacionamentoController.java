package controller;

import java.time.LocalDateTime;
import dto.ParqueEstacionamentoDto;
import exceptions.VagaInvalidaException;
import modal.Cliente;
import modal.ParqueEstacionamento;
import modal.Vaga;
import modal.Veiculo;

public class ParqueEstacionamentoController {
    private ParqueEstacionamento parqueEstacionamento;

    public ParqueEstacionamento getParqueEstacionamento() {
        return this.parqueEstacionamento;
    }

    public ParqueEstacionamentoController(int numFilas, int numVagasPorFila) {
        this.parqueEstacionamento = new ParqueEstacionamento(numFilas, numVagasPorFila);
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

    public Veiculo buscarVeiculoPorCliente(Cliente cliente) {
        return parqueEstacionamento.buscarVeiculoPorCliente(cliente);
    }

    public ParqueEstacionamentoDto listarEstacionamento() {
        return new ParqueEstacionamentoDto(parqueEstacionamento.listarClientes(), parqueEstacionamento.listarVagas());
    }
}