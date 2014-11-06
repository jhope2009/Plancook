package inf.uct.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Javier on 29-10-2014.
 */
public class Conexion {

    private  Connection conexion=null;
    private String servidor="db.inf.uct.cl:3306";
    private String database="jhope2009";
    private String usuario="jhope2009";
    private String password="jhope2009";
    private String url="";

    public Conexion(){
        try {

            Class.forName("com.mysql.jdbc.Driver");
            url="jdbc:mysql://"+servidor+"/"+database;
            conexion= DriverManager.getConnection(url, usuario, password);
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
        catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }

    public Connection getConexion(){
        return conexion;
    }

    public void close(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        conexion=null;
    }
}
