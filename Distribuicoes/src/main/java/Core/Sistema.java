/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import FuncoesDistribuicoes.C_Diversos;
import FuncoesDistribuicoes.Calculo;
import FuncoesDistribuicoes.D_Exponencial;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author marco
 */
public class Sistema {
    protected final int tempoMaximo;
    private int entidadesSistema;
    private boolean primeiraLinha = true;
    
    private Entidade entidadade;
    private Recurso recurso;
    
    protected LinkedList<Integer> tec;
    protected LinkedList<Integer> ts;
    protected LinkedList<Integer> relogio;
    protected LinkedList<Integer> fila;
    
    
    protected LinkedList<Integer> tempoInicioServico;
    protected LinkedList<Integer> tempoFila;
    protected LinkedList<Integer> tempoFinal;
    protected LinkedList<Integer> tempoSistema;
    protected LinkedList<Integer> tempoLivreRecurso;

    public Sistema(int tempoMaximo) {
        this.tempoMaximo = tempoMaximo;
        this.entidadesSistema = 0;
        
        
        tec = new LinkedList();
        ts = new LinkedList();
        relogio = new LinkedList();
        
        fila = new LinkedList();
        
        tempoInicioServico = new LinkedList();
        tempoFila = new LinkedList();
        tempoFinal = new LinkedList();
        tempoSistema = new LinkedList();
        tempoLivreRecurso = new LinkedList();
    }
    
    public void setEntidade(Entidade entidade){
        this.entidadade = entidade;
    }
    
    public void setRecurso(Recurso recurso){
        this.recurso=recurso;
    }
    
    public void executar(){
        
        tec.add
            (entidadade.getTempoChegada());
        
        ts.add
            (recurso.getTempoServico());
        
        if(primeiraLinha){
            relogio.add
                (entidadade.getTempoChegada());
            
            tempoInicioServico.add
                (relogio.getLast());
             
            tempoLivreRecurso.add
                (relogio.getLast());
            
            primeiraLinha = false;
        }else{
            relogio.add
                (relogio.getLast() + entidadade.getTempoChegada());
            
            tempoInicioServico.add
                (C_Diversos.maiorValor
                    (tempoFila.getLast(), relogio.getLast())
            );
            
            tempoLivreRecurso.add
                (tempoInicioServico.getLast() - tempoFinal.getLast());
        }
        
        tempoFila.add
                (tempoInicioServico.getLast() - relogio.getLast());
 
        tempoFinal.add
            (ts.getLast() + tempoInicioServico.getLast());
        
        tempoSistema.add
            (ts.getLast() + tempoFila.getLast());
        
        
        
    }
    
}
