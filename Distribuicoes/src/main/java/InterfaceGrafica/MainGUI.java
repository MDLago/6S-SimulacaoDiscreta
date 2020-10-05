/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author marco
 */
public class MainGUI extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public MainGUI() {
        initComponents();
        inicializar();
        
    }
    
    public void inicializar(){
        b_dUniforme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JF_Uniforme().setVisible(true);
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
        b_dUniforme = new javax.swing.JButton();
        b_dTriangular = new javax.swing.JButton();
        b_dExponencial = new javax.swing.JButton();
        b_dNormal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal");
        setLocation(new java.awt.Point(250, 250));
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(496, 159));
        setMinimumSize(new java.awt.Dimension(496, 159));
        setPreferredSize(new java.awt.Dimension(496, 159));
        setResizable(false);
        setSize(new java.awt.Dimension(614, 193));

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        b_dUniforme.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        b_dUniforme.setText("Uniforme");
        b_dUniforme.setMargin(null);
        b_dUniforme.setMaximumSize(new java.awt.Dimension(120, 40));
        b_dUniforme.setMinimumSize(new java.awt.Dimension(120, 40));
        b_dUniforme.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel1.add(b_dUniforme);

        b_dTriangular.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        b_dTriangular.setText("Triangular");
        b_dTriangular.setMargin(null);
        b_dTriangular.setMaximumSize(new java.awt.Dimension(120, 40));
        b_dTriangular.setMinimumSize(new java.awt.Dimension(120, 40));
        b_dTriangular.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel1.add(b_dTriangular);

        b_dExponencial.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        b_dExponencial.setText("Exponencial");
        b_dExponencial.setMargin(null);
        b_dExponencial.setMaximumSize(new java.awt.Dimension(120, 40));
        b_dExponencial.setMinimumSize(new java.awt.Dimension(120, 40));
        b_dExponencial.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel1.add(b_dExponencial);

        b_dNormal.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        b_dNormal.setText("Normal");
        b_dNormal.setMargin(null);
        b_dNormal.setMaximumSize(new java.awt.Dimension(120, 40));
        b_dNormal.setMinimumSize(new java.awt.Dimension(120, 40));
        b_dNormal.setPreferredSize(new java.awt.Dimension(120, 40));
        jPanel1.add(b_dNormal);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_dExponencial;
    private javax.swing.JButton b_dNormal;
    private javax.swing.JButton b_dTriangular;
    private javax.swing.JButton b_dUniforme;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
