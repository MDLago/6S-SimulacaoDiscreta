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
public class D_Uniforme extends Calculo{
    
    public static D_Uniforme getD_Uniforme(double a, double b, double c, double d){
        return new D_Uniforme(a, b, c, d);
    }

    public D_Uniforme(double d, double d1, double d2, double d3) {
        super(d, d1, d2, d3);
    }
    
    public double gerarNumero(double valorA, double valorB){        
        return valorA + (valorB - valorA)*gna.gerarNumero();
    }

    @Override
    public double gerarNumero() {
        return gerarNumero(a, b);
    }
}
