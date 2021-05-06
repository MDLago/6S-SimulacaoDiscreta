package ifsc.sj.std29006;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface que deve ser compartilhada por servidor e clientes
 *
 * http://docente.ifsc.edu.br/mello
 */
public interface ContadorDistribuido extends Remote{

    public void incrementa() throws RemoteException;
    public int obtemValorAtual()  throws RemoteException;

}
