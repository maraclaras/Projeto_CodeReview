package view;

public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
        bttnCliente.addActionListener(this::bttnClienteActionPerformed);
        bttnEstacionamento.addActionListener(this::bttnEstacionamentoActionPerformed);
        bttnSair.addActionListener(this::bttnSairActionPerformed);

    }
    @SuppressWarnings("unchecked")

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Maintitle = new javax.swing.JLabel();
        Mainquestion = new javax.swing.JLabel();
        bttnCliente = new javax.swing.JButton();
        bttnEstacionamento = new javax.swing.JButton();
        bttnSair = new javax.swing.JButton();
        MaintextCliente = new javax.swing.JLabel();
        MaintextEstacionamento = new javax.swing.JLabel();
        MaintextSair = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Maintitle.setText("SEJA BEM VINDO AO PARQUE ESTACIONAMENTO");

        Mainquestion.setText("Digite uma Opção:");

        bttnCliente.setText("1");

        bttnEstacionamento.setText("2");

        bttnSair.setText("3");

        MaintextCliente.setText("Área do Cliente");

        MaintextEstacionamento.setText("Área do Estacionamento");

        MaintextSair.setText("Sair");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(Maintitle))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(bttnCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(MaintextCliente))
                            .addComponent(Mainquestion)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(bttnEstacionamento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(MaintextEstacionamento, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(bttnSair)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(MaintextSair, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(Maintitle)
                .addGap(27, 27, 27)
                .addComponent(Mainquestion)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bttnCliente)
                    .addComponent(MaintextCliente))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bttnEstacionamento)
                    .addComponent(MaintextEstacionamento))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bttnSair)
                    .addComponent(MaintextSair))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
    
    private void bttnClienteActionPerformed(java.awt.event.ActionEvent evt) {
        TelaClienteView telaClienteView = new TelaClienteView();
        telaClienteView.setVisible(true);
        this.setVisible(false);
    }

    private void bttnEstacionamentoActionPerformed(java.awt.event.ActionEvent evt) {
        TelaEstacionamentoView telaRegistrarClienteEstacionamentoView = new TelaEstacionamentoView();
        telaRegistrarClienteEstacionamentoView.setVisible(true);
        this.setVisible(false);
    }

    private void bttnSairActionPerformed(java.awt.event.ActionEvent evt) {
        // Fecha a aplicação
        System.exit(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaClienteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    private javax.swing.JLabel Mainquestion;
    private javax.swing.JLabel MaintextCliente;
    private javax.swing.JLabel MaintextEstacionamento;
    private javax.swing.JLabel MaintextSair;
    private javax.swing.JLabel Maintitle;
    private javax.swing.JButton bttnCliente;
    private javax.swing.JButton bttnEstacionamento;
    private javax.swing.JButton bttnSair;
    private javax.swing.JPanel jPanel1;
}