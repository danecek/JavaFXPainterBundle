/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.richclient.controller;

import javafx.application.Platform;
import org.mu.utils.Messages;

public class ExitAction extends PainterAction {
    
    public static ExitAction INST = new ExitAction();

    private ExitAction() {
        super(Messages.Exit.getMess());
    }

    @Override
    void execute() {
        Platform.exit();
    }

}
