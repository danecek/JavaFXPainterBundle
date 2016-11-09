/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.integration;

import java.util.List;
import org.mu.model.MyElement;
import org.mu.utils.PainterException;

public interface ElementDAO {

    void create(MyElement e) throws PainterException;

    List<MyElement> all() throws PainterException;

}
