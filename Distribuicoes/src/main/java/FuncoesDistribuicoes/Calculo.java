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
public abstract class Calculo {
    public final double a, b, c, d;
    
    public GNA gna = new GNA();

    public Calculo(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public abstract double gerarNumero();
}
