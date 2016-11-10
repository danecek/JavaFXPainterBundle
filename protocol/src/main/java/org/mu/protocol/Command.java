/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.protocol;

import org.mu.business.FacadeService;
import org.mu.utils.PainterException;

public abstract class Command {

    static final String OK = "OK";

    abstract Object execute(FacadeService facadeService) throws PainterException;
}
