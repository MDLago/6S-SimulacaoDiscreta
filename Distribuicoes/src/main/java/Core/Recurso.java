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
    protected final int tempoServico;

    public Recurso(int tempoServico) {
        this.tempoServico = tempoServico;
    }

    public int getTempoServico() {
        return tempoServico;
    }
}
