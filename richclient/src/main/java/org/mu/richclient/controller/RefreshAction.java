/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.richclient.controller;

import org.mu.richclient.PainterAction;
import org.mu.business.FacadeService;
import org.mu.richclient.MyObservable;
import org.mu.richclient.MyAlert;
import org.mu.utils.Messages;
import org.mu.utils.PainterException;

/**
 *
 * @author Administrator
 */
public class RefreshAction extends PainterAction {
    
    public static RefreshAction INST = new RefreshAction();

    public RefreshAction() {
        super(Messages.Refresh.getMess());
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
            FacadeService facade = FacadeService.getService();
            return facade.isConnected() && FacadeService.getService().all().isEmpty();
        } catch (PainterException ex) {
            MyAlert.error(ex);
        }
        return false;
    }

}
