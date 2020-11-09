/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FuncoesDistribuicoes;

/**
 *
 * @author marco
 */
public enum Distribuicoes {
    EXPONENCIAL("Exponencial"),
    NORMAL("Normal"),
    TRIANGULAR("Triangular"),
    UNIFORME("Uniforme"),
    DETERMINISTICO("Deterministico");
    
    private final String str;

    private Distribuicoes(String str) {
        this.str = str;
    }

    @Override    
    public String toString() {
        return str;
    }
}
