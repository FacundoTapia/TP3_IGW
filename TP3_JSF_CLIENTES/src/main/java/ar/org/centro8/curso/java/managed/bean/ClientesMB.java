package ar.org.centro8.curso.java.managed.bean;

import ar.org.centro8.curso.java.aplicaciones.entities.Cliente;
import ar.org.centro8.curso.java.aplicaciones.repositories.interfaces.I_ClienteRepository;
import ar.org.centro8.curso.java.aplicaciones.repositories.jdbc.ClienteRepository;
import ar.org.centro8.curso.java.connectors.Connector;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named()
@SessionScoped

public class ClientesMB implements Serializable{
    private I_ClienteRepository cr = new ClienteRepository(Connector.getConnection());
    private Cliente cliente = new Cliente();
    private String mensaje = "";
    private String buscarApellido = "";

    public void save(){
        try {
            cr.save(cliente);
            
            if (cliente.getId()>0) {
                mensaje = "El clientes se dio de alta con el id: " + cliente.getId();
            } else {
                mensaje = "Ocurrio un error";
            }
            
            cliente = new Cliente();
        } catch (Exception e) {
            mensaje = "Ocurrio un error";
        }
    }
    
    public List<Cliente> getAll(){
        return cr.getAll();
    }
    
    public List<Cliente> getLikeApellido(){
        return  cr.getLikeApellido(buscarApellido);
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getBuscarApellido() {
        return buscarApellido;
    }

    public void setBuscarApellido(String buscarApellido) {
        this.buscarApellido = buscarApellido;
    }
}
