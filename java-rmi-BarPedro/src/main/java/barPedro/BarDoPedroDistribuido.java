/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barPedro;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author marco
 */
public interface BarDoPedroDistribuido extends Remote{
   public boolean comprarProduto(int id) throws RemoteException;
   public boolean comprarLanche(int id) throws RemoteException;
   public Mensagem getProdutos() throws RemoteException;
}
