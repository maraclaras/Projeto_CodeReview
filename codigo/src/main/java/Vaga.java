public abstract class Vaga{
  protected int numero;
  protected boolean veiculoNaVaga;
  protected Veiculo veiculo;

  public Vaga(int numero){
    this.numero = numero;
    this.veiculoNaVaga = false;
  }


  void vincularVeiculo(Veiculo veiculo, Cliente cliente){
    this.veiculo = veiculo;
    this.veiculoNaVaga = true;
    System.out.println("Veiculo " + veiculo.getPlaca() + " do cliente" + cliente.getCpf() + " estacionado");
  }

  public abstract double calcularTaxa();
  
  public boolean getVeiculoNaVaga(){
    return veiculoNaVaga;
  }

  public int getNumero(){
    return numero;
  }

  public void liberarVaga(){
    this.veiculoNaVaga = false;
    this.veiculo = null;
  }

}