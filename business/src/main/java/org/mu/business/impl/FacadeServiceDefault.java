/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.business.impl;

import java.util.Collection;
import org.mu.business.FacadeService;
import org.mu.integration.DAOFactory;
import org.mu.model.MyElement;
import org.mu.utils.PainterException;

public class FacadeServiceDefault extends FacadeService {

    @Override
    public void create(MyElement elm) throws PainterException {
        DAOFactory.service().getElementDAO().create(elm);
    }

    @Override
    public Collection<MyElement> all() throws PainterException {
        return DAOFactory.service().getElementDAO().all();
    }

    @Override
    public void clearAll() throws PainterException {
        DAOFactory.service().getElementDAO().clearAll();
    }

    @Override
    public boolean isConnected() {
        return true;
    }

}
