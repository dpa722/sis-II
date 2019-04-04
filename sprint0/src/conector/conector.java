/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * prueva de gladys de git
 */

package conector;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author daniel
 */
public class conector {
    
    private final static String url = "jdbc:mysql://Localhost:3306/postres";
    private final static String user = "root";
    private final static String password = "";
    public Connection conectar(){
        Connection conexion = null;
        try{
           
            conexion = (Connection) DriverManager.getConnection(url,user,password);
            System.out.println("conexion exitosa");
        }catch(SQLException e){
            System.out.println("Error en la conexion");
            e.printStackTrace();
        }
        return conexion;
    }
}
