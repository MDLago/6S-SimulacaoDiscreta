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
public class D_Exponencial extends Calculo{
    public static D_Exponencial getD_Exponencial(double a, double b, double c, double d){
        return new D_Exponencial(a, b, c, d);
    }

    public D_Exponencial(double a, double b, double c, double d) {
        super(a, b, c, d);
    }
    
    private double calcularAlpha(double media, double offset){
        return 1 / (media - offset);
    }
    
    public double gerarNumeroSemOffset(double media){
        double num = gna.gerarNumero();
        
        return -(media)*Math.log(num);
        
    }
    
    public double gerarNumeroComOffset(double media, double offset){
        double num = gna.gerarNumero();
        
        return offset - (1/calcularAlpha(media, offset)) * Math.log(num);
    }

    @Override
    public double gerarNumero() {
        
        if(c == 1){
            return gerarNumeroComOffset(a, b);
        }else{
            return gerarNumeroSemOffset(a);
        }
        
    }
}
