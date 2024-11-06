package controller;

import dto.ParqueEstacionamentoDto;
import exceptions.VagaInvalidaException;
import modal.Cliente;
import modal.ParqueEstacionamento;
import modal.Vaga;
import modal.Veiculo;

public class ParqueEstacionamentoController {
    private ParqueEstacionamento parqueEstacionamento;

    public ParqueEstacionamentoController(int numFilas, int numVagasPorFila) {
        this.parqueEstacionamento = new ParqueEstacionamento(numFilas, numVagasPorFila);
    }

    public void registrarCliente(Cliente cliente) {
        parqueEstacionamento.registrarCliente(cliente);
    }

    public Cliente buscarClientePorCpf(String cpf) {
        return parqueEstacionamento.buscarClientePorCpf(cpf);
    }

    public void estacionarVeiculo(Veiculo veiculo, Cliente cliente) {
        try {
            parqueEstacionamento.estacionarVeiculo(veiculo, cliente);
            System.out.println("Veículo " + veiculo.getPlaca() + " estacionado com sucesso.");
        } catch (VagaInvalidaException e) {
            System.out.println(e.getMessage());
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
