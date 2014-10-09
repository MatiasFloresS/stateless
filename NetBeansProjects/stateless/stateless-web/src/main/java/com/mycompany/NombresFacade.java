/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author matias
 */
@Stateless
public class NombresFacade extends AbstractFacade<Nombres> {
    @PersistenceContext(unitName = "com.mycompany_stateless-web_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NombresFacade() {
        super(Nombres.class);
    }
    
}
