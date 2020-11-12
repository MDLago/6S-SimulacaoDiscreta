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
public class Entidade {
    protected final int tempoChegada;
    private int tempoFila = 0;

    public Entidade(int tempoChegada) {
        this.tempoChegada=tempoChegada;
    }

    public int getTempoChegada() {
        return tempoChegada;
    }
    
    public int getTempoFila(){
        return tempoFila;
    }
    
    public void ficouNaFila(){
        tempoFila++;
    }
    
}
