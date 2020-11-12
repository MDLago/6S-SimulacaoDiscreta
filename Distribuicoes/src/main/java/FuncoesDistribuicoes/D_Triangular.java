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
public class D_Triangular extends Calculo{
    
    public static D_Triangular getD_Triangular(double a, double b, double c, double d){
        return new D_Triangular(a, b, c, d);
    }

    public D_Triangular(double a, double b, double c, double d) {
        super(a, b, c, d);
    }
    
    public double gerarNumero(double min, double max, double moda){
        double num = gna.gerarNumero();
        
        if((moda-min)/(max-min)>num){
            return min + Math.sqrt(num*(moda-min)*(max-min));
        }else{
            return max - Math.sqrt((1-num)*(max-moda)*(max-min));
        }
    }

    @Override
    public double gerarNumero() {
        return gerarNumero(a, b, c);
    }

}
