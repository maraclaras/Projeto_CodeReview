package view;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import DAO.Cliente;

public class TelaRemoverClienteView extends javax.swing.JFrame {

    public TelaRemoverClienteView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Remoção dos Dados do Cliente");

        jLabel2.setText("Digite o CPF do Cliente Para Remover:");

        jButton1.setText("Buscar Cliente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Confirmar Remoção");
        jButton2.setEnabled(false); // Inicialmente desabilitado
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Voltar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 156, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        String cpf = jTextField1.getText();

        if (cpf.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um CPF.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            if (Cliente.buscarClientePorCpf(cpf) != null) { // Verifica se o cliente existe
                JOptionPane.showMessageDialog(this, "Cliente encontrado! CPF: " + cpf, "Cliente Encontrado", JOptionPane.INFORMATION_MESSAGE);
                jButton2.setEnabled(true); // Habilita o botão "Confirmar Remoção"
            } else {
                JOptionPane.showMessageDialog(this, "CPF não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        String cpf = jTextField1.getText();

        if (cpf.isEmpty() || cpf.length() != 11) {
            JOptionPane.showMessageDialog(this, "CPF inválido! Por favor, insira um CPF válido.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja remover o cliente com CPF " + cpf + "?",
                                                        "Confirmação de Remoção", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                boolean removido = Cliente.removerCliente(cpf); // Remove do repositório
                if (removido) {
                    JOptionPane.showMessageDialog(this, "Cliente com CPF " + cpf + " removido com sucesso!",
                                                  "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    jTextField1.setText(""); // Limpa o campo de CPF
                    jButton2.setEnabled(false); // Desabilita o botão "Confirmar Remoção"

                    // Atualizar a tela de listagem
                    TelaListarClientesView telaListar = (TelaListarClientesView) SwingUtilities.getWindowAncestor(this);
                    if (telaListar != null) {
                        telaListar.atualizarLista();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao remover o cliente. Verifique o CPF.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        TelaClienteView telaCliente = new TelaClienteView();
        telaCliente.setVisible(true);
        this.setVisible(false);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRemoverClienteView().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
}
