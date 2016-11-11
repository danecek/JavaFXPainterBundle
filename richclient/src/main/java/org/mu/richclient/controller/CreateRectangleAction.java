/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.richclient.controller;

import org.mu.richclient.PainterAction;
import org.mu.utils.Messages;


public class CreateRectangleAction extends PainterAction {
    
    public static CreateRectangleAction INST = new CreateRectangleAction();

    private CreateRectangleAction() {
        super(Messages.Create_Rectangle.getMess());
    }

    @Override
    public void execute() {
        new CreateRectDialog().execute();
    }

}
