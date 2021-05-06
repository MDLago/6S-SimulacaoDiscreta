package ifsc.sj.std29006.server;

import ifsc.sj.std29006.ContadorDistribuido;
import java.rmi.RemoteException;

/**
* Classe que implementa a interface do objeto distribuído
*
* http://docente.ifsc.edu.br/mello
*/
public class Contador implements ContadorDistribuido{

    private int valor = 0;

    @Override
    public void incrementa() throws RemoteException {
        this.valor++;
    }

    @Override
    public int obtemValorAtual() throws RemoteException {
        return this.valor;
    }
}
