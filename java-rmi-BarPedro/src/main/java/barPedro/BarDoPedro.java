/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barPedro;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author marco
 */
public class BarDoPedro implements BarDoPedroDistribuido{
    
    private Map<Produto, Integer> produtos = new HashMap<>();

    public BarDoPedro() {
        gerarProdutos();  
    }
    
    @Override
    public boolean comprarProduto(int id) throws RemoteException{
        return produtos.containsValue(id);
    }

    @Override
    public boolean comprarLanche(int id) throws RemoteException{
        return false;
    }

    @Override
    public Mensagem getProdutos() throws RemoteException{
        String str = "";
        
        for (Map.Entry<Produto, Integer> entry : produtos.entrySet()) {
            Produto produto = entry.getKey();
            
            str += "ID: " + produto.getId()+" - "+produto.getNome()+"\n";
            
        }
        
        return new Mensagem(str);
    }
    
    private void gerarProdutos(){
        produtos.put(new Produto(1, "Coxinha"), 1);
        produtos.put(new Produto(2, "Refrigerante"), 2);
        produtos.put(new Produto(3, "Bolacha"), 3);
    }
    
}
