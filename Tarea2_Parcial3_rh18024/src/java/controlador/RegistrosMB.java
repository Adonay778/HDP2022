/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.Registration;
import modelo.entidades.Categorias;
import modelo.entidades.Registro;
import modelo.sesion.beans.CategoriasFacade;
import modelo.sesion.beans.RegistroFacade;
import util.JSFUtil;

/**
 *
 *
 *
 * @author enriq
 */
@ManagedBean
@RequestScoped
public class RegistrosMB implements Serializable {

    @Inject
    RegistroFacade registrofacade;

    @Inject
    CategoriasFacade categoriasFacade;
    private List<Registro> ListaRegistro;
    private List<Categorias> ListaCategorias;
    private Registro registrar;
    private Categorias categorias;

    public RegistrosMB() {
        this.registrar = new Registro();
        this.categorias = new Categorias();
        registrar.setCategoriaid(categorias);
    }

    public List<Registro> getListaRegistro() {
        return ListaRegistro;
    }

    public void setListaRegistro(List<Registro> ListaRegistro) {
        this.ListaRegistro = ListaRegistro;
    }

    public String guardarRegistro() {
        registrofacade.create(registrar);
        registrar = new Registro();
        registrar.setCategoriaid(categorias);
        JSFUtil.addGlobalMessage("Sitio Agregada");
        return "";
    }

    public String modificarRegistro() {
        registrofacade.edit(registrar);
        return "";
    }

    public Registro getRegistrar() {
        return registrar;
    }

    public void setRegistrar(Registro registrar) {
        this.registrar = registrar;
    }

    public List<Categorias> getListaCategorias() {
        return ListaCategorias;
    }

    public void setListaCategorias(List<Categorias> ListaCategorias) {
        this.ListaCategorias = ListaCategorias;
    }

    public Categorias getCategorias() {
        return categorias;
    }

    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
    }

    public void init() {
        this.registrar = new Registro();
        this.categorias = new Categorias();
        listarCategorias();
        listarRegistro();

    }

    public List<Registro> listarRegistro() {
        this.ListaRegistro = registrofacade.findAll();
        return this.ListaRegistro;
    }

    public List<Categorias> listarCategorias() {
        this.ListaCategorias = categoriasFacade.findAll();
        return this.ListaCategorias;
    }

    public void createCapacitacion() {
        this.registrar.setCategoriaid(this.categorias);
        this.registrofacade.create(this.registrar);
    }

    public void guardarActualizar() {
        FacesMessage mensaje = new FacesMessage();
        mensaje.setSeverity(FacesMessage.SEVERITY_INFO);
        this.registrar.setCategoriaid(this.categorias);
        if (this.registrar != null) {
            this.registrofacade.edit(this.registrar);
            mensaje.setSummary("Capacitacion guadada exitosamente !!");

        } else {
            mensaje.setSummary("Capacitacion  NO guadada exitosamente !!");
            init();
            mensaje.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage("Mensaje", mensaje);
        }
    }

    public void eliminar() {
        FacesMessage mensaje = new FacesMessage();
        if (this.registrar != null) {
            mensaje.setSeverity(FacesMessage.SEVERITY_INFO);
            mensaje.setSummary("Registro eliminado exitosamente");
            registrofacade.remove(this.registrar);
            mensaje.setSeverity(FacesMessage.SEVERITY_INFO);
        }
    }

}
