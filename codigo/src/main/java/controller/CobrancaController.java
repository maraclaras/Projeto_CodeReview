package controller;

import java.util.Scanner;

import DAO.ClienteDAO;
import DAO.Cobranca;
import DAO.Vaga;
import DAO.Veiculo;
import modal.ParqueEstacionamento;

public class CobrancaController {
    private ParqueEstacionamento estacionamento;
    private Scanner leitor;

    public CobrancaController(ParqueEstacionamento estacionamento, Scanner leitor) {
        this.estacionamento = estacionamento;
        this.leitor = leitor;
    }

    public void calcularTaxaCliente() {
        System.out.println("Digite o CPF do cliente:");
        String cpf = leitor.next();

        ClienteDAO cliente = estacionamento.buscarClientePorCpf(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        Veiculo veiculo = estacionamento.buscarVeiculoPorCliente(cliente);
        if (veiculo == null) {
            System.out.println("Veículo não encontrado para o cliente.");
            return;
        }

        Vaga vaga = estacionamento.obterVagaPorVeiculo(veiculo);
        if (vaga == null) {
            System.out.println("Vaga não encontrada para o veículo.");
            return;
        }

        System.out.print("Digite o tempo (em minutos) que o veículo ficou estacionado: ");
        int minutos = leitor.nextInt();
        leitor.nextLine(); // Consumir a quebra de linha

        Cobranca cobranca = new Cobranca();
        double valor = cobranca.calcularValor(minutos, vaga);
        System.out.println("Valor total da cobrança: R$ " + valor);

        // Cobrar o cliente
        cobranca.cobrarCliente(cpf, valor);
    }
}