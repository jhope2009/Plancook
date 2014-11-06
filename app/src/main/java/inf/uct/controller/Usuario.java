package inf.uct.controller;

/**
 * Created by Javier on 29-10-2014.
 */
public class Usuario {

    public String email;
    public String nombre;
    public String apellido;
    public String pass;

    public Usuario(){}

    public Usuario(String email, String nombre, String apellido, String pass) {
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pass = pass;
    }


}
