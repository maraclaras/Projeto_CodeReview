package view;

import DAO.ClienteDAO;
import DAO.VagaDAO;
import DAO.Veiculo;
import modal.ParqueEstacionamento;  

public class TelaConsultaVagaView extends javax.swing.JFrame {

    private javax.swing.JLabel resultadoVagaLabel;

    public TelaConsultaVagaView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        
        // Criar e configurar o JLabel para mostrar o resultado da consulta
        resultadoVagaLabel = new javax.swing.JLabel();
        resultadoVagaLabel.setText("Vaga: Não Encontrado");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Consultar Vaga do Veículo");

        jLabel2.setText("Digite a Placa do Veículo:");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(resultadoVagaLabel))  // Adicionando o JLabel ao layout
                        .addGap(0, 234, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resultadoVagaLabel)  // Exibindo a vaga encontrada
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Obtendo a placa informada
        String placa = jTextField1.getText().trim();

        // Verificando se a placa é válida
        if (placa.isEmpty()) {
            resultadoVagaLabel.setText("Placa não informada!");
            return;
        }

        // Buscar o veículo associado à placa (supondo que você tenha esse método na classe ParqueEstacionamento)
        Veiculo veiculo = null;
        for (ClienteDAO cliente : ParqueEstacionamento.clientes) {
            veiculo = cliente.buscarVeiculoPorPlaca(placa);  // Método que busca o veículo do cliente pela placa
            if (veiculo != null) {
                break;
            }
        }

        // Exibir o resultado
        if (veiculo != null) {
            // Buscar a vaga onde o veículo está estacionado
            VagaDAO vaga = ParqueEstacionamento.getInstancia(0, 0).obterVagaPorVeiculo(veiculo);
            if (vaga != null) {
                resultadoVagaLabel.setText("Vaga: " + vaga.getIdentificador());
            } else {
                resultadoVagaLabel.setText("Veículo não está estacionado.");
            }
        } else {
            resultadoVagaLabel.setText("Veículo não encontrado.");
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        TelaEstacionamentoView telaCliente = new TelaEstacionamentoView();
        telaCliente.setVisible(true);
        this.setVisible(false);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaConsultaVagaView().setVisible(true);
            }
        });
    }

    // Variáveis declaradas
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
}
