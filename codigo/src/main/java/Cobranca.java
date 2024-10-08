import java.util.Scanner;

public class Cobranca {
    private static final float TAXA_POR_MINUTO = 4.0f;
    private static final float MAX_COBRANCA = 50.0f;
    private double totalCobranca;
    private int minutosTotal;

    // Método para calcular o valor de cobrança com base no tempo de estacionamento e no tipo de vaga
    public double calcularValor(int minutosEstacionado, Vaga vaga) {
        // Calcula o valor base multiplicando os minutos pela taxa por minuto
        double valorBase = minutosEstacionado * TAXA_POR_MINUTO;

        // Se o valor base ultrapassar o valor máximo, limita o valor ao máximo
        if (valorBase > MAX_COBRANCA) {
            valorBase = MAX_COBRANCA;
        }

        // Aplica o desconto ou acréscimo específico com base no tipo de vaga
        totalCobranca = vaga.calcularTaxa(valorBase);

        return totalCobranca;
    }

    // Método para calcular os minutos estacionados com base no horário de entrada e saída (em minutos)
    public int calcularMinutos(int horaInicio, int horaFinal) {
        minutosTotal = horaFinal - horaInicio;
        // Verifica se o horário final é anterior ao inicial, indicando erro
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

        // Aqui você deve buscar o cliente pelo CPF
        Cliente cliente = estacionamento.buscarClientePorCpf(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        // Aqui você deve buscar o veículo associado a esse cliente
        Veiculo veiculo = estacionamento.buscarVeiculoPorCliente(cliente);
        if (veiculo == null) {
            System.out.println("Veículo não encontrado para o cliente.");
            return;
        }

        // Calcular a taxa, por exemplo, baseado em minutos de estacionamento
        System.out.println("Digite o tempo (em minutos) que o veículo ficou estacionado:");
        int minutosEstacionados = leitor.nextInt();

        // Supondo que você tenha um método na classe para obter a vaga do veículo
        Vaga vaga = estacionamento.obterVagaPorVeiculo(veiculo);
        if (vaga == null) {
            System.out.println("Vaga não encontrada para o veículo.");
            return;
        }

        // Calcular o valor a ser cobrado
        double valor = calcularValor(minutosEstacionados, vaga);
        System.out.println("Valor a ser cobrado para o cliente " + cpf + ": R$ " + valor);

        // Cobra o cliente
        cobrarCliente(cpf, valor);
    }

    // Método para calcular a taxa para VIP
    public double calcularTaxaVIP(int minutosEstacionado, VIP vagaVIP) {
        return calcularValor(minutosEstacionado, vagaVIP);
    }

    // Método para calcular a taxa para Idosos
    public double calcularTaxaIdosos(int minutosEstacionado, Idosos vagaIdosos) {
        return calcularValor(minutosEstacionado, vagaIdosos);
    }

    // Método para calcular a taxa para PCD
    public double calcularTaxaPCD(int minutosEstacionado, PCD vagaPCD) {
        return calcularValor(minutosEstacionado, vagaPCD);
    }

    // Método para exibir o valor total calculado
    public double mostrarValorTotal() {
        return totalCobranca;
    }

    // Método para cobrar o cliente e exibir a cobrança
    public void cobrarCliente(String cpf, double totalCobranca) {
        System.out.println("Cliente com CPF " + cpf + " foi cobrado no valor de: R$ " + totalCobranca);
    }
}