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
    private int tec, ultimoTec = 0;
    private int ts;
    //private int tempoUltimaEntidadeCriada = 0;
    private int proximaEntidade = 1;
    
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
        do{
            setTEC(cTEC.gerarNumero());
        }while (valorMenorIgualZero(tec));
        
        ultimoTec = tec;
        ent = new Entidade(tec);
        addEntidadeEntraram();
        fila.add(ent);
    }
    
    public void criarEntidade(){
        if(proximaEntidade == 1){
            adicionarEntidade();
            
            proximaEntidade = ultimoTec;
        }else{
            proximaEntidade--;
        }
    }
    ////////////////////////////////////
    
    private void addTempoFila(){
        if(!fila.isEmpty()){
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
            rec.atendimento();
            qtdTempoRecursoLivre.add(1);
        }else{
            do{
                setTS(cTS.gerarNumero());
            }while (valorMenorIgualZero(ts));
            rec.setTS(ts);
            
            Entidade ent = fila.getFirst();
            
            if(ent.getTempoFila() > 0){
                qtdTempoFila.add(ent.getTempoFila());
            }
            
            qtdTempoSistema.add(ent.getTempoFila() + rec.getTS());
            fila.removeFirst();
        }
        
     }
    
    private void atendimentoEntidadeAtual(){
        if(rec.isRecursoLivre() || rec.getContador() == 1){
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
    
    public double getQtdMediaEntidadesFila(){
        double res = 0;
        for (Integer integer : qtdFila) {
            res += integer;
        }
        res = res/qtdFila.size();
        
        return res;
    }

    public double getTaxaOcupacaoServidor(){
        double res = 0;
        
        for (Integer integer : qtdTempoRecursoLivre) {
            res += integer;
        }
        
        res = 1 - (res/tempo);
        
        return res;
    }
    
    public double getTempoMedioEntidadeFila(){
        double res = 0;
        
        for (Integer integer : qtdTempoFila) {
            res += integer;
        }
        
        res = res / qtdTempoFila.size();
        
        return res;
    }
    
    public double getTempoMedioEntidadeSistema(){
        double res = 0;
        
        for (Integer integer : qtdTempoSistema) {
            res += integer;
        }
        
        res = res / qtdTempoSistema.size();
        
        return res;
    }
    
    public int getTotalEntidadesSistema(){
        return entidadeEntraram;
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
    
    private boolean valorMenorIgualZero(int valor){
        return valor <= 0;
    }
}
