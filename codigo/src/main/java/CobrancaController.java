import java.util.Scanner;

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

        Cobranca cobranca = new Cobranca();
        double valor = cobranca.calcularValor(minutosEstacionados, vaga);
        System.out.println("Valor a ser cobrado para o cliente " + cpf + ": R$ " + valor);

        cobranca.cobrarCliente(cpf, valor);
    }
}
