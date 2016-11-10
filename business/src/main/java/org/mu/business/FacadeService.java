/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.business;

import java.util.Collection;
import org.mu.business.impl.FacadeServiceDefault;
import org.mu.model.MyElement;
import org.mu.utils.PainterException;

public abstract class FacadeService {

    private static FacadeService service;

    public static FacadeService getService() {
        if (service == null) {
            service = new FacadeServiceDefault();
        }
        return service;
    }

    public abstract void create(MyElement elm) throws PainterException;

    public abstract Collection<MyElement> all()  throws PainterException;

}
