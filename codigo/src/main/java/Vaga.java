public class Vaga extends Veiculo{
  int numero;
  boolean veiculoNaVaga;

  void vincularVeiculo(Veiculo veiculo, Cliente cliente){
    this.veiculo = cliente;
  }
}