package rmicomunica;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIcm extends Remote {

    public float massa_corporea(String cpf, float altura, float peso) throws Exception;
}
