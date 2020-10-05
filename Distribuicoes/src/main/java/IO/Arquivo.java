/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

/**
 *
 * @author marco
 */
public class Arquivo {
    File file;
    
    public void criarArquivo(Path path) throws IOException{
        file = new File(path.toUri());
        file.createNewFile();
    }
    
    public void escreverArquivo(double valor) throws IOException{
        FileWriter fIO = new FileWriter(file,true);
        BufferedWriter bIO = new BufferedWriter(fIO);
        
        bIO.write(String.valueOf(valor));
        bIO.newLine();
        bIO.close();
    }
    
    
}
