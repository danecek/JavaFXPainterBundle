/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.protocol;

import org.mu.business.FacadeService;
import org.mu.model.MyElement;
import org.mu.utils.PainterException;

/**
 *
 * @author Administrator
 */
public class CreateCommand extends Command {

    private final MyElement elm;

    public CreateCommand(MyElement elm) {
        this.elm = elm;
    }

    @Override
    Object execute(FacadeService facadeService) throws PainterException {
        facadeService.create(elm);
        return OK;
    }

}
