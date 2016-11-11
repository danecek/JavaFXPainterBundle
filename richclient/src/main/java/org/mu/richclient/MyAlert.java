/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.richclient;

import javafx.application.Platform;
import javafx.scene.control.Alert;

public class MyAlert {

    public static void error(Exception ex) {
        error(ex.toString());
    }

    public static void error(String mess) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText(mess);
                a.showAndWait();
            }
        });
    }

}
