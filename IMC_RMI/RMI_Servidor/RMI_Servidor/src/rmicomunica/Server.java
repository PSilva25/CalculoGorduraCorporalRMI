package rmicomunica;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Server {
    
    public static void main(String[] args) throws RemoteException, Exception {
        
        try{
        
            System.setProperty("java.rmi.server.hostname", "192.168.43.158");
            Registry reg = LocateRegistry.createRegistry(5001);
            
            reg.rebind("calcular massa corporea",new Implementacao());
          
            System.out.println("servidor tá rodando. Roda cliente Desgraçado ");
            
        }catch(MalformedURLException ex){
        
        }   
            
            
        
            
        
    

    }



}
