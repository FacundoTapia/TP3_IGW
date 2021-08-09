package ar.org.centro8.curso.java.managed.bean;

import ar.org.centro8.curso.java.aplicaciones.entities.Articulo;
import ar.org.centro8.curso.java.aplicaciones.repositories.interfaces.I_ArticuloRepository;
import ar.org.centro8.curso.java.aplicaciones.repositories.jdbc.ArticuloRepository;
import ar.org.centro8.curso.java.connectors.Connector;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named()
@SessionScoped
public class ArticulosMB implements Serializable{
    private I_ArticuloRepository ar =  new ArticuloRepository(Connector.getConnection());
    private Articulo articulo = new Articulo();
    private String mensaje = "";
    private String buscarDescripcion = "";
    
    public void save(){
        try {
            ar.save(articulo);
            if(articulo.getId()>0)  {
                mensaje = "Se dio de alta el articulo con id:" + articulo.getId();
            } else {
                mensaje = "Ocurrio un error";
            }
            articulo = new Articulo();
        } catch (Exception e) {
            mensaje = "Ocurrio un error";
        }
    }
    
    public List<Articulo> getAll(){
        return ar.getAll();
    }
    
    public List<Articulo> getLikeDescripcion(){
        return ar.getLikeDescripcion(buscarDescripcion);
    }
    
    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getBuscarDescripcion() {
        return buscarDescripcion;
    }

    public void setBuscarDescripcion(String buscarDescripcion) {
        this.buscarDescripcion = buscarDescripcion;
    }
}