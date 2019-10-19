
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mauricio
 */
public class ControladorPaquetes {

    String nombre;
    List<ControladorClases> listaClase;
    List<ControladorPaquetes> listaPaquetes;

    public ControladorPaquetes() {
        listaClase = new ArrayList<>();
        listaPaquetes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<ControladorPaquetes> getListaPaquetes() {
        return listaPaquetes;
    }

    public void setListaPaquetes(List<ControladorPaquetes> listaPaquetes) {
        this.listaPaquetes = listaPaquetes;
    }

    public List<ControladorClases> getListaClase() {
        return listaClase;
    }

    public void setListaClase(List<ControladorClases> listaClase) {
        this.listaClase = listaClase;
    }

}
