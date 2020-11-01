/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author marco
 */
public class Sistema {
    protected final int tempoMaximo;
    private int idEntidade;
    private int entidadesSistema;
    
    protected List tec;
    protected List ts;
    protected List relogio;
    protected List tempoFinal;
    protected List tempoSistema;

    public Sistema(int tempoMaximo) {
        this.tempoMaximo = tempoMaximo;
        this.idEntidade = 1;
        this.entidadesSistema = 0;
        
        
        tec = new LinkedList();
        ts = new LinkedList();
        relogio = new LinkedList();
        tempoFinal = new LinkedList();
        tempoSistema = new LinkedList();
    }
    
    
    
}
