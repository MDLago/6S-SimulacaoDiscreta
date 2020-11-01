/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FuncoesDistribuicoes;

import java.util.List;

/**
 *
 * @author marco
 */
public abstract class C_Diversos {
    public static int maiorValor(int v1, int v2){
        if(v1 >= v2){
            return v1;
        }else{
            return v2;
        }
    }
    
    public static int somaList(List<Integer> l){
        int valor = 0;
        for (Integer integer : l) {
            valor += integer;
        }
        return valor;
    }
}
