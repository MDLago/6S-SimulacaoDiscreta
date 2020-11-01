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
public class D_Uniforme implements Calculo{
    
    public static D_Uniforme getD_Uniforme(){
        return new D_Uniforme();
    }
    
    public double gerarNumero(double valorA, double valorB){
        GNA gna = GNA.getGNA();
        
        return valorA + (valorB - valorA)*gna.gerarNumero();
    }

    @Override
    public double gerarNumero(double a, double b, double c, double d) {
        return gerarNumero(a, b);
    }
}
