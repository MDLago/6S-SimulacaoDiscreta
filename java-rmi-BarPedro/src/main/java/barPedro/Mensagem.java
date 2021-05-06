/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barPedro;

import java.io.Serializable;

/**
 *
 * @author marco
 */
public class Mensagem implements Serializable{
    public final String str;

    public Mensagem(String str) {
        this.str = str;
    }
    
    
}
