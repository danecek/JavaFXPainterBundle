/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.integration.impl;

import org.mu.integration.DAOFactory;
import org.mu.integration.ElementDAO;

/**
 *
 * @author Administrator
 */
public class DefaultDAOFactory extends DAOFactory {

    public ElementDAO getElementDAO() {
        return DefaultElementDAO.INST;
    }

}
