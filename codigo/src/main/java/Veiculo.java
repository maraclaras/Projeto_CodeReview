public class Veiculo {
 private String placa;
 private String modelo;
 private Cliente proprietario;

 public Veiculo(String placa, String modelo, Cliente proprietario) {
   this.placa = placa;
   this.modelo = modelo;
   this.proprietario = proprietario;
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
