package modal;
public class Veiculo {
    private String placa;
    private String modelo;
    private Cliente proprietario;

    // Construtor que inicializa a placa e o modelo
    public Veiculo(String placa, String modelo) {
        this.placa = placa;
        this.modelo = modelo;
        this.proprietario = null; // Inicialmente, o veículo não tem proprietário
    }

    public Veiculo(String placa) {
        this.placa = placa;
    }

    // Getter para o modelo
    public String getModelo() {
        return modelo;
    }

    // Getter para a placa
    public String getPlaca() {
        return placa;
    }

    // Getter para o proprietário
    public Cliente getProprietario() {
        return proprietario;
    }

    // Método para vincular o cliente (proprietário) ao veículo
    public void vincularCliente(Cliente cliente) {
        this.proprietario = cliente;
        cliente.adicionarVeiculo(this); // Vincula o veículo ao cliente
    }

    @Override
    public String toString() {
        return "Veículo com placa: " + placa;
    }
}
