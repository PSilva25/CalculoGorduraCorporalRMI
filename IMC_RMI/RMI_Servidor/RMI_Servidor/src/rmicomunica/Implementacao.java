package rmicomunica;


import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Implementacao extends UnicastRemoteObject implements RMIcm {
    
    
    String CPF;
    float imc_atual;
    float imc_passado;
    float diferenca;
    
    
    ArrayList <DADOS> dados = new ArrayList<DADOS>();
    
    DAO c = new DAO();
    
    
    
    public Implementacao()throws Exception{
    
        super();
    
    }
    
    
   
    public float massa_corporea(String cpf, float altura, float peso) throws Exception {
     
        float massa = 0;
               
        
        pegaDados(cpf);
        
   
         massa = Calculo(cpf, altura, peso);
           
        
        return  massa;
    
    }
    
    
    
    
    public void pegaDados(String CPF) throws SQLException {
        
               
        c.conexao();

        c.executaSQL("select * from sd_imc where CPF = "+CPF);
   
        c.rs.first();
        do{
            
            DADOS data = new DADOS();
            
            data.setID(c.rs.getInt("ID"));
            data.setNOME(c.rs.getString("NOME"));
            data.setCPF(c.rs.getString("CPF"));
            data.setPESO(c.rs.getFloat("PESO"));
            data.setALTURA(c.rs.getFloat("ALTURA"));
            data.setIMC(c.rs.getFloat("IMC"));
            
            dados.add(data);
              
            System.out.println("0");
            
        }while(c.rs.next());
        
    }
    
    
    
    public float Calculo(String cpf, float altura, float peso) throws SQLException {
        
    
        imc_atual = peso / (altura * altura);
                
        diferenca = dados.get(0).getIMC() - imc_atual;
        
        System.out.println("IMC |PRIMARIO "+ dados.get(0).getIMC());
        
        System.out.println("IMC ATUAL "+ imc_atual);
        
        System.out.println("DIFERENCA "+ diferenca);
        
        Registra(cpf, peso, altura, imc_atual);
           
        return diferenca;   
        
    }
    
    
    
    public void Registra(String cpf, float altura, float peso, float imc) throws SQLException{
        
        c.conexao();

  
            String sql = "insert into sd_imc (CPF, NOME, PESO, ALTURA, IMC) values (?, ?, ?, ?, ?);";
                
            PreparedStatement stmt = c.conn.prepareStatement(sql);
                    
            stmt.setString(1, cpf);
            stmt.setString(2, dados.get(0).getNOME());
            stmt.setFloat(3, peso);
            stmt.setFloat(4, altura); 
            stmt.setFloat(5, imc);             
                    
            stmt.execute();
                
            stmt.close();
               
     }

    

    

    

    
                
            
          
            
    
    
    
}
