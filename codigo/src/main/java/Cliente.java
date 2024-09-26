import java.util.ArrayList;
import java.util.List; //pra conseguir listar

public class Cliente {
    private String nome;
    private String cpf;
    private List<Veiculo> listaVeiculos;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.listaVeiculos = new ArrayList<>();
    }

    public void criarCliente() {
        System.out.println("Cliente criado: " + nome + ", CPF: " + cpf);
    }

    public void removerCliente() {
        System.out.println("Cliente removido: " + nome + ", CPF: " + cpf);
    }

    public void alterarCliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        System.out.println("Cliente alterado: " + nome + ", CPF: " + cpf);
    }

    public void vincularVeiculo(Veiculo veiculo) {
        veiculo.vincularCliente(this);
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        listaVeiculos.add(veiculo);
    }

    public List<Veiculo> listarVeiculos() {
        return listaVeiculos;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }
}