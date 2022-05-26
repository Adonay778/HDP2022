/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import modelo.entidades.Categorias;
import modelo.entidades.Registro;
import modelo.sesion.beans.CategoriasFacade;
import modelo.sesion.beans.RegistroFacade;
import util.JSFUtil;

/**
 *
 * @author enriq
 */
@ManagedBean
@ViewScoped
public class CategoriasMB implements Serializable {


    @Inject
    CategoriasFacade categoriasFacade;

  
    private Categorias categorias;

    public CategoriasMB() {
      
        this.categorias = new Categorias();
        
    }

    public List<Categorias> getListaCategorias() {
        return categoriasFacade.findAll();
    }

    public List<Categorias> getListaRegistro() {
        return categoriasFacade.findAll();
    }

    public String guardarCategoria() {
        categoriasFacade.create(categorias);
        
        JSFUtil.addGlobalMessage("Categoria Agregada");
        return "";
    }

    public String modificarRegistro() {
       categoriasFacade.edit(categorias);
        return "";
    }

    public Categorias getRegistrar() {
        return categorias;
    }

    public void setRegistrar(Categorias categorias) {
        this.categorias = categorias;
    }
}
