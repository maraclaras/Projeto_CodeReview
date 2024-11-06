package modal;

import java.util.Scanner;

public class Cobranca {
    private static final float TAXA_POR_MINUTO = 4.0f;
    private static final float MAX_COBRANCA = 50.0f;
    private double totalCobranca;
    private int minutosTotal;

    // Método para calcular o valor de cobrança com base no tempo de estacionamento e no tipo de vaga
    public double calcularValor(int minutosEstacionado, Vaga vaga) {
        double valorBase = minutosEstacionado * TAXA_POR_MINUTO;
        if (valorBase > MAX_COBRANCA) {
            valorBase = MAX_COBRANCA;
        }
        totalCobranca = vaga.calcularTaxa(valorBase);
        return totalCobranca;
    }

    // Método para calcular os minutos estacionados com base no horário de entrada e saída (em minutos)
    public int calcularMinutos(int horaInicio, int horaFinal) {
        minutosTotal = horaFinal - horaInicio;
        if (minutosTotal < 0) {
            System.out.println("Horário inválido. A hora de saída não pode ser anterior à hora de entrada.");
            minutosTotal = 0;
        }
        return minutosTotal;
    }

    // Método para calcular a taxa para um cliente específico
    public void calcularTaxaCliente(ParqueEstacionamento estacionamento, Scanner leitor) {
        System.out.println("Digite o CPF do cliente:");
        String cpf = leitor.next();
        Cliente cliente = estacionamento.buscarClientePorCpf(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        Veiculo veiculo = estacionamento.buscarVeiculoPorCliente(cliente);
        if (veiculo == null) {
            System.out.println("Veículo não encontrado para o cliente.");
            return;
        }

        System.out.println("Digite o tempo (em minutos) que o veículo ficou estacionado:");
        int minutosEstacionados = leitor.nextInt();
        Vaga vaga = estacionamento.obterVagaPorVeiculo(veiculo);
        if (vaga == null) {
            System.out.println("Vaga não encontrada para o veículo.");
            return;
        }

        double valor = calcularValor(minutosEstacionados, vaga);
        System.out.println("Valor a ser cobrado para o cliente " + cpf + ": R$ " + valor);
        cobrarCliente(cpf, valor);
    }

    public double calcularTaxaVIP(int minutosEstacionado, VIP vagaVIP) {
        return calcularValor(minutosEstacionado, vagaVIP);
    }

    public double calcularTaxaIdosos(int minutosEstacionado, Idosos vagaIdosos) {
        return calcularValor(minutosEstacionado, vagaIdosos);
    }

    public double calcularTaxaPCD(int minutosEstacionado, PCD vagaPCD) {
        return calcularValor(minutosEstacionado, vagaPCD);
    }

    public double mostrarValorTotal() {
        return totalCobranca;
    }

    public void cobrarCliente(String cpf, double totalCobranca) {
        System.out.println("Cliente com CPF " + cpf + " foi cobrado no valor de: R$ " + totalCobranca);
    }
}
