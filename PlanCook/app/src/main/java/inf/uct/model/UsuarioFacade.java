package inf.uct.model;

import android.util.Log;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import inf.uct.controller.Usuario;

/**
 * Created by Javier on 29-10-2014.
 */
public class UsuarioFacade {

    public Usuario find(String email, String pass){
        Conexion con=null;
        PreparedStatement ps=null;
        Usuario user=null;

        String sql="SELECT * FROM usuario WHERE email=? AND pass=?";
        try{
            con=new Conexion();
            ps=con.getConexion().prepareStatement(sql);
            ps.setString(1,email);
            ps.setString(2,pass);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
                user=new Usuario(rs.getString("email"),rs.getString("nombre"),rs.getString("apellido"),rs.getString("pass"));

        }catch (SQLException ex){
            Log.e("ERROR -> UsuarioFacade -> find: ",ex.getMessage());
        }finally {
            if(con!=null) con.close();
        }
        return user;
    }

    public boolean save(Usuario user){
        Conexion con=null;
        PreparedStatement ps=null;

        String sql="INSERT INTO usuario(email,nombre,apellido,pass) VALUES (?,?,?,?)";
        try{
            con=new Conexion();
            ps=con.getConexion().prepareStatement(sql);
            ps.setString(1,user.email);
            ps.setString(2,user.nombre);
            ps.setString(3,user.apellido);
            ps.setString(4, user.pass);
            ps.executeUpdate();
            return true;

        }catch (SQLException ex){
            Log.e("ERROR -> UsuarioFacade -> save ",ex.getMessage());
            return false;
        }finally {
            if(con!=null) con.close();
        }
    }
}
