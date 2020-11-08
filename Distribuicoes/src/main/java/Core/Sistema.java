/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import FuncoesDistribuicoes.Calculo;
import java.util.LinkedList;

/**
 *
 * @author marco
 */
public class Sistema {
    
    private int tempo = 0;
    private final int tempoMaximo;
    private int entidadeEntraram = 0;
    private int entidadeSairam = 0;
    private int qtdMaximoEntidadeDentro = 0;
    
    private Calculo cTEC;
    private Calculo cTS;
    private int tec;
    private int ts;
    private int tempoUltimaEntidadeCriada = 0;
    
    private LinkedList<Entidade> fila = new LinkedList<>();
    private Entidade ent;
    public Recurso rec = new Recurso();
    
    private LinkedList<Integer> qtdFila = new LinkedList<>();
    private LinkedList<Integer> qtdTempoRecursoLivre = new LinkedList<>();
    private LinkedList<Integer> qtdTempoFila = new LinkedList<>();
    private LinkedList<Integer> qtdTempoSistema = new LinkedList<>();

    public Sistema(int tempoMaximo, Calculo ts, Calculo tec) {
          this.tempoMaximo = tempoMaximo;
          this.cTS = ts;
          this.cTEC = tec;
          
          setValores(cTS.gerarNumero(), cTEC.gerarNumero());
    }
    
    ///////////////////////////////////////
    private void adicionarEntidade(){
        ent = new Entidade(tec);
        setValores(cTS.gerarNumero(), cTEC.gerarNumero());
        addEntidadeEntraram();
        fila.add(ent);
    }
    
    public void criarEntidade(){
        if(tempo == tempoUltimaEntidadeCriada + tec){
            adicionarEntidade();
            tempoUltimaEntidadeCriada = tempo;
        }
    }
    ////////////////////////////////////
    
    private void addTempoFila(){
        if(fila.isEmpty()){
            for (Entidade entidade : fila) {
                entidade.ficouNaFila();
            }
        }
    }
    public void addtempo(){
        tempo++;
    } 
    
    ///////////////////////////////////
    
    private void verificarFila(){
        qtdFila.add(fila.size());
    }
    
    private void verificarQtdDentro(){
        
        int valor = entidadeEntraram - entidadeSairam;
        if(qtdMaximoEntidadeDentro < valor){
            qtdMaximoEntidadeDentro = valor;
        }
    }
    
    ////////////////////////////////////
    
    private void atenderProximaEntidade(){
        if(fila.isEmpty()){
            rec.setLivre();
            qtdTempoRecursoLivre.add(1);
        }else{
            Entidade ent = fila.getFirst();
            qtdTempoFila.add(ent.getTempoFila());
            qtdTempoSistema.add(ent.getTempoChegada() + ent.getTempoFila() + ts);
            fila.removeFirst();
            rec.setTS(ts);
        }
        
     }
    
    private void atendimentoEntidadeAtual(){
        if(rec.isRecursoLivre() || rec.getContador() == 0){
            atenderProximaEntidade();
        }else{
            rec.atendimento();
        }
        
        if(rec.isTerminouAtendimento()){
            addEntidadeSairam();
            rec.setTerminouAtendimento();
        }
    }
    //////////////////////////////////
    private void setTS(double ts){
        this.ts = (int) Math.round(ts);
    }
    private void setTEC(double tec){
        this.tec = (int) Math.round(tec);
    }
    
    public void setValores(double ts, double tec){
        setTEC(tec);
        setTS(ts);
    }
    
    /////////////////////////////////
    
    public int getTempo(){
        return tempo;
    }
    
    public int getTempoMaximo(){
        return tempoMaximo;
    }

    public int getEntidadeEntraram() {
        return entidadeEntraram;
    }

    public int getEntidadeSairam() {
        return entidadeSairam;
    }

    public int getQtdMaximoEntidadeDentro() {
        return qtdMaximoEntidadeDentro;
    }

    public LinkedList<Integer> getQtdFila() {
        return qtdFila;
    }

    public LinkedList<Integer> getQtdTempoFila() {
        return qtdTempoFila;
    }

    public LinkedList<Integer> getQtdTempoRecursoLivre() {
        return qtdTempoRecursoLivre;
    }

    public LinkedList<Integer> getQtdTempoSistema() {
        return qtdTempoSistema;
    }
    
    
    /////////////////////////////////
    
    public void executar(){
        
        
        criarEntidade();
        atendimentoEntidadeAtual();
        addTempoFila();
        verificarFila();
        verificarQtdDentro();
        
        addtempo();
    }
    
    ///////////////////////////////////////
    private void addEntidadeEntraram(){
        entidadeEntraram++;
    }
    
    private void addEntidadeSairam(){
        entidadeSairam++;
    }
}
