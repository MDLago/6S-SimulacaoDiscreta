/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import FuncoesDistribuicoes.Calculo;
import FuncoesDistribuicoes.D_Triangular;
import IO.Arquivo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author marco
 */
public class JF_Triangular extends javax.swing.JFrame {
    Path path;
    /**
     * Creates new form JF_Uniforme
     */
    public JF_Triangular() {
        
        initComponents();
        inicializar();
        
    }
    
    private void inicializar(){
        btnEscolher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = Utils.getJFC_TXT();
                
                int retorno = fc.showOpenDialog(fc);
                if (retorno == JFileChooser.APPROVE_OPTION) {
                    File arquivo = fc.getSelectedFile();
                    arquivo = Arquivo.adicionarExtensao(arquivo, Arquivo.EXT.TXT);
                    localArquivo.setText(arquivo.getAbsolutePath());
                    path = arquivo.toPath();
                }
            }
        });
        
        btnGerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double minimo = Utils.valorJTF_Double(valorMinimo);
                double maximo = Utils.valorJTF_Double(valorMaximo);
                double moda = Utils.valorJTF_Double(valorModa);
                int qtd = Utils.valorJTF_Int(qtdNumeros);
                
                Arquivo arq = new Arquivo();
                
                try {
                    arq.criarArquivo(path);
                    Calculo calc = D_Triangular.getD_Triangular(minimo, maximo,moda,0);
                    
                    for (int i = 0; i < qtd; i++) {
                        double num = calc.gerarNumero();
                        arq.escreverArquivo(num);
                    }
                    
                    JOptionPane.showMessageDialog(null, "Concluido");
                } catch (IOException ex) {
                    Logger.getLogger(JF_Triangular.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        valorMinimo = new javax.swing.JTextField();
        valorMaximo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        qtdNumeros = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        localArquivo = new javax.swing.JTextField();
        btnEscolher = new javax.swing.JButton();
        btnGerar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        valorModa = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Distribuição Triangular");
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(350, 400));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel1.setText("Parametros");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setText("Minimo: ");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setText("Maximo: ");

        valorMinimo.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        valorMinimo.setMinimumSize(new java.awt.Dimension(100, 20));
        valorMinimo.setName(""); // NOI18N
        valorMinimo.setPreferredSize(new java.awt.Dimension(100, 20));

        valorMaximo.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        valorMaximo.setMaximumSize(new java.awt.Dimension(100, 20));
        valorMaximo.setMinimumSize(new java.awt.Dimension(100, 20));
        valorMaximo.setName(""); // NOI18N
        valorMaximo.setPreferredSize(new java.awt.Dimension(100, 20));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel4.setText("Quantidade de números: ");

        qtdNumeros.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        qtdNumeros.setMaximumSize(new java.awt.Dimension(100, 20));
        qtdNumeros.setMinimumSize(new java.awt.Dimension(100, 20));
        qtdNumeros.setName(""); // NOI18N
        qtdNumeros.setPreferredSize(new java.awt.Dimension(100, 20));

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel5.setText("Local do arquivo: ");

        localArquivo.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        localArquivo.setMaximumSize(new java.awt.Dimension(100, 20));
        localArquivo.setMinimumSize(new java.awt.Dimension(100, 20));
        localArquivo.setName(""); // NOI18N
        localArquivo.setPreferredSize(new java.awt.Dimension(100, 20));

        btnEscolher.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnEscolher.setText("Escolher");
        btnEscolher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEscolherMouseClicked(evt);
            }
        });

        btnGerar.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnGerar.setText("Gerar");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel6.setText("Moda:");

        valorModa.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        valorModa.setMaximumSize(new java.awt.Dimension(100, 20));
        valorModa.setMinimumSize(new java.awt.Dimension(100, 20));
        valorModa.setName(""); // NOI18N
        valorModa.setPreferredSize(new java.awt.Dimension(100, 20));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(localArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(qtdNumeros, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGerar)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(75, 75, 75)
                                .addComponent(btnEscolher)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addGap(27, 27, 27)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(valorMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(valorMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(valorModa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel6))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(valorMinimo, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(valorMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(valorModa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(qtdNumeros, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(jLabel5))
                    .addComponent(btnEscolher))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(localArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGerar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEscolherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEscolherMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEscolherMouseClicked

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
            java.util.logging.Logger.getLogger(JF_Triangular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Triangular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Triangular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Triangular.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_Triangular().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEscolher;
    private javax.swing.JButton btnGerar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField localArquivo;
    private javax.swing.JTextField qtdNumeros;
    private javax.swing.JTextField valorMaximo;
    private javax.swing.JTextField valorMinimo;
    private javax.swing.JTextField valorModa;
    // End of variables declaration//GEN-END:variables
}
