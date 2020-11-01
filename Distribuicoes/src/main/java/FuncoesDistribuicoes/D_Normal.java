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
public class D_Normal implements Calculo{
    GNA gna;
    
    public D_Normal(){
        gna = new GNA();
    }
    
    public static D_Normal getD_Normal() {
        return new D_Normal();
    }
    
    private double calcularZ(){
        double num1 = gna.gerarNumero();
        double num2 = gna.gerarNumero();
        
       return Math.sqrt(Math.abs((-2)*Math.log(num1)))
               * Math.sin((2*Math.PI)*num2);
    }
    
    public double gerarNumero(double media, double desvio){
        return media + (desvio * calcularZ());

    }

    @Override
    public double gerarNumero(double a, double b, double c, double d) {
        return gerarNumero(a, b);
    }
}
