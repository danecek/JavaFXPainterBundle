/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.richclient;

import java.util.Observable;

/**
 *
 * @author Administrator
 */
public class MyObservable extends Observable {
    public static MyObservable INST = new MyObservable();

    private MyObservable() {
    }

    public void changed() {
        setChanged();
        notifyObservers();
    }
    
    
}
