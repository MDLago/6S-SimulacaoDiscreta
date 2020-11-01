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
    private final int id;
    protected final int tempoChegada;

    public Entidade(int id, int tempoChegada) {
        this.id=id;
        this.tempoChegada=tempoChegada;
    }

    public int getId() {
        return id;
    }

    public int getTempoChegada() {
        return tempoChegada;
    }
    
}
