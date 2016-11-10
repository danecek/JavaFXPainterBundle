/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.integration.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mu.integration.ElementDAO;
import org.mu.model.MyElement;
import org.mu.model.MyElementId;

/**
 *
 * @author Administrator
 */
public class DefaultElementDAO implements ElementDAO {
    
    public static ElementDAO INST = new DefaultElementDAO();

    private final Map<MyElementId, MyElement> elems = new HashMap<>();
    int counter;

    private DefaultElementDAO() {
    }


    @Override
    public void create(MyElement elm) {
        elm.setId(new MyElementId(counter++));
        elems.put(elm.getId(), elm);
    }

    @Override
    public List<MyElement> all() {
        return new ArrayList<>(elems.values());
    }

}
