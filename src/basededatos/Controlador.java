
package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Controlador {
    String url = "sample.db";
    Connection connect;
    int pos = -1;
    
    public void connect(){
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:"+url);
            if (connect!=null) {
//                System.out.println("Conectado");
            }
        }catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos\n"+ex.getMessage());
        }
       }
        public void close(){
               try {
                   connect.close();
               } catch (SQLException ex) {
                   Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
               }
        }
        
    public void insertar(Usuarios usuario){
        try {
            PreparedStatement st = connect.prepareStatement("insert into usuarios (id,nombre,contraseña) values (?,?,?)");
            st.setInt(1, usuario.getId());
            st.setString(2, usuario.getNombre());
            st.setString(3, usuario.getContraseña());
            st.execute();
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
 
    }
    
    
        
}
