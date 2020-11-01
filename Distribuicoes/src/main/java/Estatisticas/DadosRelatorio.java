/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Estatisticas;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author marco
 */
public class DadosRelatorio {
    private final List filaEntidade;
    private final List tempoEntidadeFila;
    private final List tempoEntidadeSistema;
    private int contadorEntidade;
    private final List maximoEntidadeSimultaneaSistema;

    public DadosRelatorio(){
        filaEntidade = new LinkedList();
        tempoEntidadeFila = new LinkedList();
        tempoEntidadeSistema = new LinkedList();
        maximoEntidadeSimultaneaSistema = new LinkedList();
        contadorEntidade = 0;
    }
    
    public void addEntidade(int valor){
        filaEntidade.add(valor);
    }
    
    public void addTempoEntidadeFila(int valor){
        tempoEntidadeFila.add(valor);
    }
    
    public void addTempoEntidadeSistema(int valor){
        tempoEntidadeSistema.add(valor);
    }
    
    public void addMaximoEntidadeSimultaneaSistema(int valor){
        maximoEntidadeSimultaneaSistema.add(valor);
    }
    
    public void addContatorEntidade(){
        contadorEntidade++;
    }
    
    public void addDados (int filaEntidade, int tempoEntidadeFila, int tempoEntidadeSistema, int maximoEntidadeSimultaneaSistema){
        addEntidade(filaEntidade);
        addTempoEntidadeFila(tempoEntidadeFila);
        addTempoEntidadeSistema(tempoEntidadeSistema);
        addMaximoEntidadeSimultaneaSistema(maximoEntidadeSimultaneaSistema);
        addContatorEntidade();
    }
}
