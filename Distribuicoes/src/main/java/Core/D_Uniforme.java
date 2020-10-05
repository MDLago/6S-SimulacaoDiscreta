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
public class D_Uniforme{
    public double gerarNumero(double valorA, double valorB){
        GNA gna = GNA.getGNA();
        
        return valorA + (valorB - valorA)*gna.gerarNumero();
    }
}
