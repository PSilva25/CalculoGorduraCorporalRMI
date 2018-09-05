
package rmicomunica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
//import Principal.Cadastro_de_Produtos;
//import Principal.Cadastro_de_Produtos;

/**
 *
 * @author Jonycássio Almondes
 */
public class DAO {
    
    public Statement stm;
    public ResultSet rs;
    private String driver = "com.mysql.jdbc.Driver";
    private String caminho = "jdbc:mysql://localhost:3306/sd";
    private String usuario = "root";
    private String senha = "";
    public Connection conn;
    
    
    
    public void conexao(){
         
        try {
            
            System.setProperty("jdbc.Drivers", driver);
            
            conn = DriverManager.getConnection(caminho, usuario, senha);
            
            System.out.println("Conectado");
            
        } catch (SQLException ex) {
            
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        
            System.out.println("Erro de conexão");
            
        }
         
    }
    
    
    public void executaSQL(String SQL){
        
        try {
            
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
        
            rs = stm.executeQuery(SQL);
            
        } catch (SQLException ex) {
       
            //Logger.getLogger(Cadastro_de_Produtos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}



