/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.richclient.controller;

import org.mu.richclient.PainterAction;
import org.mu.richclient.JavaFXPainter;
import org.mu.utils.Messages;

public class ExitAction extends PainterAction {

    public static ExitAction INST = new ExitAction();

    private ExitAction() {
        super(Messages.Exit.getMess());
    }

    @Override
    public void execute() {
      //  JavaFXPainter.INST.shutdownPlatform();
    }

}
