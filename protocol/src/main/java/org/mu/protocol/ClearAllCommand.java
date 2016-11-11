/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.protocol;

import org.mu.business.FacadeService;
import org.mu.utils.PainterException;

public class ClearAllCommand extends Command {

    @Override
    public Object execute(FacadeService facadeService) throws PainterException {
        facadeService.clearAll();
        return OK;
    }

}
