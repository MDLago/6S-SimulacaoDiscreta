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
public class D_Exponencial implements Calculo{
    public static D_Exponencial getD_Exponencial(){
        return new D_Exponencial();
    }
    
    private double calcularAlpha(double media, double offset){
        return 1 / (media - offset);
    }
    
    public double gerarNumeroSemOffset(double media){
        GNA gna = GNA.getGNA();
        double num = gna.gerarNumero();
        
        return -(media)*Math.log(num);
        
    }
    
    public double gerarNumeroComOffset(double media, double offset){
        GNA gna = GNA.getGNA();
        double num = gna.gerarNumero();
        
        return offset - (1/calcularAlpha(media, offset)) * Math.log(num);
    }

    @Override
    public double gerarNumero(double a, double b, double c, double d) {
        
        if(c == 1){
            return gerarNumeroComOffset(a, b);
        }else{
            return gerarNumeroSemOffset(a);
        }
        
    }
}
