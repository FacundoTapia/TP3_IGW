package ar.org.centro8.curso.java.managed.bean;

import ar.org.centro8.curso.java.enums.EstadoCivil;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named()
@SessionScoped
public class EstadoCivilMB implements Serializable{
    public List<EstadoCivil> getEstados(){
        return List.of(EstadoCivil.values());
    }
}
