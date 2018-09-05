package rmicomunica;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

public class Cliente {

    public static void main(String[] args) {

        try {

            Registry x = LocateRegistry.getRegistry("192.168.43.158", 5001);

            RMIcm z = (RMIcm) x.lookup("calcular massa corporea");

            String cpf = JOptionPane.showInputDialog("insira seu cpf: ");
            String peso = JOptionPane.showInputDialog("insira seu peso: ");
            String altura = JOptionPane.showInputDialog("insira sua altura ");

            float p = Float.valueOf(peso);
            float A = Float.valueOf(altura);

            JOptionPane.showMessageDialog(null, "massa antiga - massa atual = " + z.massa_corporea(cpf, A, p));

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}
