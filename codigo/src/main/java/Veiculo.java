public class Veiculo {
  private String placa;
  private String modelo; // Correto agora
  private Cliente proprietario;

  public Veiculo(String placa, String modelo, Cliente proprietario) {
      this.placa = placa;
      this.modelo = modelo;
      this.proprietario = proprietario;
  }

  // Getter para o campo modelo
  public String getModelo() {
      return modelo;
  }

  public String getPlaca() {
      return placa;
  }

  public Cliente getProprietario() {
      return proprietario;
  }

  public void vincularCliente(Cliente cliente) {
      this.proprietario = cliente;
      cliente.vincularVeiculo(this); 
  }
}
