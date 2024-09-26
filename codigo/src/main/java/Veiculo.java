public class Veiculo {
  String placa;
  String modelo;
  Cliente proprietario;

  void vincularCliente(Cliente cliente) {
      this.proprietario = cliente;
      cliente.vincularVeiculo(this); 
  }
}
