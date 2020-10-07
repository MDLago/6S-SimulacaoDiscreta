/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

/**
 *
 * @author marco
 */
public class D_Triangular implements Calculo{
    
    public static D_Triangular getD_Triangular(){
        return new D_Triangular();
    }
    
    public double gerarNumero(double min, double max, double moda){
        GNA gna = GNA.getGNA();
        double num = gna.gerarNumero();
        
        if((moda-min)/(max-min)>num){
            return min + Math.sqrt(num*(moda-min)*(max-min));
        }else{
            return max - Math.sqrt((1-num)*(max-moda)*(max-min));
        }
    }

    @Override
    public double gerarNumero(double a, double b, double c, double d) {
        return gerarNumero(a, b, c);
    }
}
