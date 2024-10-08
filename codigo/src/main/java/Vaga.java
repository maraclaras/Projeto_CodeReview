public class Vaga{
  private String identificador;
  private boolean ocupada;
  private static int maxVagas;  // Número máximo de vagas permitido no estacionamento
  private static int vagasCriadas = 0;  // Contador de vagas criadas

  // Construtor para inicializar uma vaga com identificador alfanumérico
  public Vaga(String identificador, int maxVagasPermitidas) throws VagaInvalidaException {
      // Inicializa o número máximo de vagas na primeira instância
      if (maxVagas == 0) {
          maxVagas = maxVagasPermitidas;
      }

      // Verifica se o limite máximo de vagas foi atingido
      if (vagasCriadas >= maxVagas) {
          throw new VagaInvalidaException("Limite máximo de vagas atingido.");
      }

      // Valida o identificador da vaga
      if (!validarIdentificador(identificador)) {
          throw new VagaInvalidaException("Identificador de vaga inválido: " + identificador);
      }

      this.identificador = identificador;
      this.ocupada = false;
      vagasCriadas++;  // Incrementa o contador de vagas criadas
  }

  // Método para validar o identificador (Ex: Y08)
  private boolean validarIdentificador(String identificador) {
      // Verifica se o identificador segue o padrão "Letra + Dois Números"
      return identificador.matches("[A-Z]\\d{2}");
  }

  // Método para ocupar a vaga
  public void ocupar() throws VagaInvalidaException {
    if (ocupada) {
        throw new VagaInvalidaException("A vaga " + identificador + " já está ocupada.");
    }
    this.ocupada = true; // Marca a vaga como ocupada
    System.out.println("A vaga " + identificador + " foi ocupada.");
}
  // Método para liberar a vaga
  public void liberar() {
    this.ocupada = false; // Marca a vaga como livre
    System.out.println("A vaga " + identificador + " foi liberada.");
}

  // Método para verificar se a vaga está ocupada
  public boolean isOcupada() {
      return ocupada;
  }

  // Método para obter o identificador da vaga
  public String getIdentificador() {
      return identificador;
  }

  public double calcularTaxa(double valorBase){
    return valorBase;
  }

  @Override
  public String toString() {
      return "Vaga " + identificador + " - " + (ocupada ? "Ocupada" : "Livre");
  }

  // Método para obter o número total de vagas criadas
  public static int getVagasCriadas() {
      return vagasCriadas;
  }

  // Método para obter o número máximo de vagas permitido
  public static int getMaxVagas() {
      return maxVagas;
  }
}
