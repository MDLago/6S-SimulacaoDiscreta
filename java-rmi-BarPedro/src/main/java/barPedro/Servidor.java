/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barPedro;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author marco
 */
public class Servidor {
    private static final String IPSERVIDOR = "127.0.0.1";
    private static final int PORTA = 1234;
    private static final String NOMEOBJDIST = "BarDoPedro";
    
    public static void main(String args[]){
        try{
            
            BarDoPedro bar = new BarDoPedro();
            
            System.setProperty("java.rmi.server.hostname", IPSERVIDOR);
            
            BarDoPedroDistribuido stub = (BarDoPedroDistribuido) UnicastRemoteObject.exportObject(bar, 0);
            
            Registry registro = LocateRegistry.createRegistry(PORTA);
            
            registro.bind(NOMEOBJDIST, stub);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
