/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Estatisticas;

/**
 *
 * @author marco
 */
public class DadosRelatorio {
    
    private double numeroMedioEntidadesFila;
    private double taxaMediaOcupacaoServidor;
    private double tempoMedioEntidadeFila;
    private double tempoMedioSistema;
    private int totalEntidadesSistema;
    private int qtdEntidadesSimultaneasSistema;
    private int tempoExecucao;

    public double getNumeroMedioEntidadesFila() {
        return numeroMedioEntidadesFila;
    }

    public double getTaxaMediaOcupacaoServidor() {
        return taxaMediaOcupacaoServidor;
    }

    public double getTempoMedioEntidadeFila() {
        return tempoMedioEntidadeFila;
    }

    public double getTempoMedioSistema() {
        return tempoMedioSistema;
    }

    public int getTotalEntidadesSistema() {
        return totalEntidadesSistema;
    }

    public int getQtdEntidadesSimultaneasSistema() {
        return qtdEntidadesSimultaneasSistema;
    }

    public int getTempoExecucao() {
        return tempoExecucao;
    }

    public void setNumeroMedioEntidadesFila(double numeroMedioEntidadesFila) {
        this.numeroMedioEntidadesFila = numeroMedioEntidadesFila;
    }

    public void setTaxaMediaOcupacaoServidor(double taxaMediaOcupacaoServidor) {
        this.taxaMediaOcupacaoServidor = taxaMediaOcupacaoServidor;
    }

    public void setTempoMedioEntidadeFila(double tempoMedioEntidadeFila) {
        this.tempoMedioEntidadeFila = tempoMedioEntidadeFila;
    }

    public void setTempoMedioSistema(double tempoMedioSistema) {
        this.tempoMedioSistema = tempoMedioSistema;
    }

    public void setTotalEntidadesSistema(int totalEntidadesSistema) {
        this.totalEntidadesSistema = totalEntidadesSistema;
    }

    public void setQtdEntidadesSimultaneasSistema(int qtdEntidadesSimultaneasSistema) {
        this.qtdEntidadesSimultaneasSistema = qtdEntidadesSimultaneasSistema;
    }

    public void setTempoExecucao(int tempoExecucao) {
        this.tempoExecucao = tempoExecucao;
    }
    
    
    
    
    
}
