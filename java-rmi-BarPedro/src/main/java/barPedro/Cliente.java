/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barPedro;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

/**
 *
 * @author marco
 */
public class Cliente {
    private static final String IPSERVIDOR = "127.0.0.1";
    private static final int PORTA = 1234;
    private static final String NOMEOBJDIST = "BarDoPedro";
    
    public static void main(String args[]){
        try{
             // Obtendo referência do serviço de registro
            Registry registro = LocateRegistry.getRegistry(IPSERVIDOR, PORTA);

            // Procurando pelo objeto distribuído registrado previamente com o NOMEOBJDIST
            BarDoPedroDistribuido stub = (BarDoPedroDistribuido) registro.lookup(NOMEOBJDIST);       

            menu(stub);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private static void listarProdutos(BarDoPedroDistribuido stub) throws RemoteException{
        JOptionPane.showMessageDialog(null, stub.getProdutos().str);
    }
    
    private static void comprarProduto(BarDoPedroDistribuido stub) throws RemoteException{
        int i = Integer.valueOf(JOptionPane.showInputDialog(null, "Insira o codigo do produto: "));
        if(stub.comprarProduto(i)){
            JOptionPane.showMessageDialog(null, "Compra efetuado com sucesso");
        }else{
            JOptionPane.showMessageDialog(null, "Houve um erro ao processar a compra");
        }
    }
    
    private static void menu(BarDoPedroDistribuido stub) throws RemoteException {
        int i = Integer.valueOf(JOptionPane.showInputDialog(null,
                "1 - Listar Produtos\n"+
                        "2 - Comprar Produto"));
        
        System.out.println(i);
        
        switch(i){
            case 1:
                listarProdutos(stub);
                break;
            case 2:
                comprarProduto(stub);
                break;
            case 9:
                return;
            default:
                JOptionPane.showMessageDialog(null, "Opção invalida");  
        }
        
        menu(stub);
    }
}
