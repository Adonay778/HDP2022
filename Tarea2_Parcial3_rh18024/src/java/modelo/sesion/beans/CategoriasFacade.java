/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.sesion.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.entidades.Categorias;

/**
 *
 * @author enriq
 */
@Stateless
public class CategoriasFacade extends AbstractFacade<Categorias> {

    @PersistenceContext(unitName = "Tarea2_Parcial3_rh18024PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriasFacade() {
        super(Categorias.class);
    }
    
}
