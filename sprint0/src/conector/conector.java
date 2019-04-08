/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * prueva de gladys de git
 */

package conector;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Puña
 * @author Jorge Delgadillo 
 * @author Miguel Corma
 * @author Hilari Adrian
 * @author Alex Gonzales
 */
public class conector {
    
    Statement st;
    ResultSet datosResultado;
    private final static String url = "jdbc:mysql://Localhost:3306/postres";
    private final static String user = "root";
    private final static String password = "";
    //metodo para conectar con la base de datos
    Connection conexion = null;
    public conector(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(url,user,password);
            if (conexion!=null){
            System.out.println("conexion exitosa");
            st = conexion.createStatement();
            }
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error en la conexion"+e);
        }
    }
    public void verificarPostre(String nombPostre) throws SQLException{
        datosResultado = st.executeQuery("SELECT nombre FROM postres");
        boolean registrado = false;
        while (datosResultado.next()) {            
            if(nombPostre.equals(datosResultado.getObject("nombre"))){
                registrado = true;
                JOptionPane.showMessageDialog(null, "El postre ya fue registrado.");
                break;
            }
        }
        if(registrado == false){
            st.execute("INSERT INTO postre (nombre) VALUES ('"+nombPostre+"')");
            JOptionPane.showMessageDialog(null, "Postre registrado.");
        }
        conexion.close();
    }
}
