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
    
    public enum EXT{
        TXT (".txt");
        
        private final String name;
        
        private EXT(String s){
            name = s;
        }
        
        public boolean isEquals(String ext){
            return name.equals(ext);
        }
        
        @Override
        public String toString(){
            return this.name;
        }
    }
    
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
    
    public static File adicionarExtensao(File file, EXT ext){
        if(!file.getAbsolutePath().endsWith(ext.toString())){
            return new File(file+ext.toString());
        }else{
            return file;
        }
    }
    
    
}
