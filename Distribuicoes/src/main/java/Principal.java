
import InterfaceGrafica.MainGUI;
import InterfaceGrafica.Simulacao;
import javax.swing.UIManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marco
 */
public class Principal {
    public static void main(String[] args) {
        //Designa Um Look and Feel Para as janelas
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // Caso o nimbus esteja indisponível, alterar o LAF aqui.
        }
        
        MainGUI gui = new MainGUI();
        //Simulacao gui = new Simulacao();
        gui.setVisible(true);
    }
}
