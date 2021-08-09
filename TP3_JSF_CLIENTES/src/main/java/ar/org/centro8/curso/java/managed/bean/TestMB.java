package ar.org.centro8.curso.java.managed.bean;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named()
@SessionScoped()
public class TestMB implements Serializable{
    //testMB
    private String nombre="x";
    private String apellido="x";
    private String estadoCivil="Soltero";
    private String mensaje="x";
    
    public void aceptar(){
        mensaje = nombre + ", " + apellido + ", " + estadoCivil;
        nombre = "";
        apellido = "";
        estadoCivil = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
