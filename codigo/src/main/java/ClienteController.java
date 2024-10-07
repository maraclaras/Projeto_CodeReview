public class ClienteController {
  private Cliente cliente;
  private ClienteView view;

  public ClienteController(ClienteView view) {
      this.view = view;
  }

  // Inicia o menu de clientes
  public void iniciar() {
      int opcao;
      do {
          opcao = view.exibirMenu(); // Usa a view para exibir o menu e capturar a opção

          switch (opcao) {
              case 1:
                  criarCliente();
                  break;
              case 2:
                  alterarCliente();
                  break;
              case 3:
                  removerCliente();
                  break;
              case 4:
                  adicionarVeiculo();
                  break;
              case 5:
                  listarVeiculos();
                  break;
              case 6:
                  view.exibirMensagem("Saindo da área do cliente...");
                  break;
              default:
                  view.exibirMensagem("Opção inválida!");
                  break;
          }
      } while (opcao != 6);
  }

  private void criarCliente() {
      String nome = view.solicitarNomeCliente();
      String cpf = view.solicitarCpfCliente();
      cliente = new Cliente(nome, cpf);
      view.exibirMensagem("Cliente criado: " + nome + ", CPF: " + cpf);
  }

  private void alterarCliente() {
      if (cliente != null) {
          String novoNome = view.solicitarNomeCliente();
          String novoCpf = view.solicitarCpfCliente();
          cliente.setNome(novoNome);
          cliente.setCpf(novoCpf);
          view.exibirMensagem("Cliente alterado: " + novoNome + ", CPF: " + novoCpf);
      } else {
          view.exibirMensagem("Nenhum cliente cadastrado.");
      }
  }

  private void removerCliente() {
      if (cliente != null) {
          view.exibirMensagem("Cliente removido: " + cliente.getNome() + ", CPF: " + cliente.getCpf());
          cliente = null;
      } else {
          view.exibirMensagem("Nenhum cliente cadastrado.");
      }
  }

  private void adicionarVeiculo() {
      if (cliente != null) {
          String placa = view.solicitarPlacaVeiculo();
          Veiculo veiculo = new Veiculo(placa);
          cliente.adicionarVeiculo(veiculo);
          view.exibirMensagem("Veículo adicionado: " + placa);
      } else {
          view.exibirMensagem("Nenhum cliente cadastrado.");
      }
  }

  private void listarVeiculos() {
      if (cliente != null) {
          view.listarVeiculos(cliente);
      } else {
          view.exibirMensagem("Nenhum cliente cadastrado.");
      }
  }
}
