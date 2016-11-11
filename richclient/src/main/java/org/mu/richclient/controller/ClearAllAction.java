/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.richclient.controller;

import org.mu.richclient.PainterAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mu.business.FacadeService;
import org.mu.richclient.MyObservable;
import org.mu.richclient.MyAlert;
import org.mu.utils.Messages;
import org.mu.utils.PainterException;

/**
 *
 * @author Administrator
 */
public class ClearAllAction extends PainterAction {
    
    public static ClearAllAction INST = new ClearAllAction();

    public ClearAllAction() {
        super(Messages.Clear_all.getMess());
    }

    @Override
    public void execute() {
        try {
            FacadeService.getService().clearAll();
            MyObservable.INST.changed();
        } catch (PainterException ex) {
            MyAlert.error(ex);
        }
    }

    @Override
    public boolean checkDisable() {
        try {
            return FacadeService.getService().all().isEmpty();
        } catch (PainterException ex) {
            MyAlert.error(ex);
        }
        return false;
    }

}
