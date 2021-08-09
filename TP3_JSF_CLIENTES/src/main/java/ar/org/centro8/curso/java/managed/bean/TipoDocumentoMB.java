package ar.org.centro8.curso.java.managed.bean;

import ar.org.centro8.curso.java.aplicaciones.enums.tipoDocumento;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class TipoDocumentoMB implements Serializable{
    public List<tipoDocumento> getTipoDocumentos(){
        return List.of(tipoDocumento.values());
    }
}
