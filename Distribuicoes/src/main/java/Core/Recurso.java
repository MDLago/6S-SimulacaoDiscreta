/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

/**
 *
 * @author marco
 */
public class Recurso {
    protected int ts;
    private int contador = 0;
    private boolean livre = true;
    private boolean terminouAtendimento = false;
    
    public boolean isRecursoLivre(){
        return livre;
    }

    public boolean isTerminouAtendimento() {
        return terminouAtendimento;
    }
    
    public int getContador(){
        return contador;
    }
    
    public int getTS(){
        return ts;
    }
    
    public void setTS(int ts){
        this.ts = ts;
        contador = ts;
        ocupado();
    }

    public void setLivre() {
        this.livre = true;
    }
    
    

    public void setTerminouAtendimento() {
        this.terminouAtendimento = false;
    }
    
    private void livre(){
        livre = true;
    }
    
    private void ocupado(){
        livre = false;
    }
    
    public void atendimento(){
        if (contador == 2){
            terminouAtendimento = true;
        }
        
        if(contador > 0){
            contador --;
        }
        
    }
}
