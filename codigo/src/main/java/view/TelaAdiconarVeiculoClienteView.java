
package view;
import javax.swing.JOptionPane;

import DAO.ClienteDAO;
import DAO.Veiculo;

public class TelaAdiconarVeiculoClienteView extends javax.swing.JFrame {

    public TelaAdiconarVeiculoClienteView() {
        initComponents();
    }

    private ClienteDAO buscarClientePorCpf(String cpf) {
        return ClienteDAO.buscarClientePorCpf(cpf);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Buscar Cliente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Adicionar Veículo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Adicionar Veículo ");

        jLabel2.setText("Digite o CPF do Cliente:");

        jLabel3.setText("Digite a Placa do Veículo:");

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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 156, Short.MAX_VALUE))
                    .addComponent(jTextField2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String cpf = jTextField1.getText();
        String placa = jTextField2.getText();
        
        // Verifica se os campos estão preenchidos corretamente
        if (cpf.isEmpty() || placa.isEmpty() || placa.length() != 7) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um CPF e uma placa válida.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Busca o cliente pelo CPF
        ClienteDAO cliente = buscarClientePorCpf(cpf);
        if (cliente == null) {
            JOptionPane.showMessageDialog(this, "Cliente com CPF " + cpf + " não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Adiciona o veículo ao cliente
        Veiculo novoVeiculo = new Veiculo(placa); // Substitua pela criação do objeto Veiculo de acordo com sua implementação
        cliente.adicionarVeiculo(novoVeiculo);
        JOptionPane.showMessageDialog(this, "Veículo com placa " + placa + " adicionado ao cliente com CPF " + cpf + ".", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        
        // Limpa os campos e desabilita o botão "Adicionar Veículo"
        jTextField1.setText("");
        jTextField2.setText("");
        jButton2.setEnabled(false);
    }
                                     

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    this.setVisible(false); // Oculta a tela atual
    new TelaClienteView().setVisible(true); 
    }                                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String cpf = jTextField1.getText();
    
        // Verifica se o CPF foi inserido
        if (cpf.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um CPF.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        // Simula busca de cliente (você pode substituir pelo método real)
        ClienteDAO cliente = buscarClientePorCpf(cpf);
    
        if (cliente != null) {
            String nome = cliente.getNome();
            StringBuilder veiculos = new StringBuilder();
    
            // Verifica se há veículos associados ao cliente
            if (cliente.listarVeiculos().isEmpty()) {
                veiculos.append("Nenhum veículo cadastrado.");
            } else {
                for (Veiculo veiculo : cliente.listarVeiculos()) {
                    veiculos.append("- ").append(veiculo.getPlaca()).append("\n");
                }
            }
            
    
            // Exibe as informações do cliente e seus veículos
            JOptionPane.showMessageDialog(this, 
                "Cliente encontrado!\n" +
                "Nome: " + nome + "\n" +
                "Veículos:\n" + veiculos,
                "Cliente Encontrado", JOptionPane.INFORMATION_MESSAGE);
    
            jButton2.setEnabled(true); // Habilita o botão "Adicionar Veículo"
        } else {
            JOptionPane.showMessageDialog(this, "CPF não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
                                            

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaAdiconarVeiculoClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAdiconarVeiculoClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAdiconarVeiculoClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAdiconarVeiculoClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAdiconarVeiculoClienteView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration                   
}
