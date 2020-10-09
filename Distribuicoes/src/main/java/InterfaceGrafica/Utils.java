/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author marco
 */
public abstract class Utils {
    public static boolean valorJCB(JCheckBox cb){
        return cb.isSelected();
    }
    
    public static double valorJTF_Double(JTextField tf){
        if(tf.getText().isEmpty() || tf == null){
            return 0;
        }else{
            return Double.valueOf(tf.getText());
        }
    }
    
    public static int valorJTF_Int(JTextField tf){
        if(tf.getText().isEmpty() || tf == null){
            return 0;
        }else{
            return Integer.valueOf(tf.getText());
        }
    }
    
    public static JFileChooser getJFC_TXT(){
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Selecionar Arquivo");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de Texto", "txt");
        fc.setFileFilter(filter);
        
        return fc;
    }
}
