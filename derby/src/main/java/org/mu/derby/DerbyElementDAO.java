/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.derby;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mu.integration.ElementDAO;
import org.mu.model.ElementType;
import org.mu.model.MyCircle;
import org.mu.model.MyElement;
import org.mu.model.MyElementId;
import org.mu.model.MyRectangle;
import org.mu.utils.PainterException;


public class DerbyElementDAO implements ElementDAO {

    PreparedStatement createPs;
    PreparedStatement allPs;
    PreparedStatement clearAllPs;

    public DerbyElementDAO(Connection conn) {
        try {
            createPs = conn.prepareStatement("INSERT INTO ELEMENTS VALUES(DEFAULT, ?, ?, ?, ?, ?)");
            allPs = conn.prepareStatement("SELECT * FROM ELEMENTS");
            clearAllPs = conn.prepareStatement("DELETE FROM ELEMENTS");
        } catch (SQLException ex) {
            Logger.getLogger(DerbyElementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void create(MyElement me) throws PainterException {
        try {
            createPs.setString(1, me.getElementType().name());
            createPs.setDouble(2, me.getRefX());
            createPs.setDouble(3, me.getRefY());
            switch (me.getElementType()) {
                case Circle: {
                    MyCircle c = (MyCircle) me;
                    createPs.setDouble(4, c.getRadius());
                    createPs.setDouble(5, 0);
                    break;
                }
                case Rectangle: {
                    MyRectangle r = (MyRectangle) me;
                    createPs.setDouble(4, r.getWidth());
                    createPs.setDouble(5, r.getHeight());
                    break;
                }
            }
            createPs.executeUpdate();
        } catch (SQLException ex) {
            throw new PainterException(ex);
        }
    }

    @Override
    public List<MyElement> all() throws PainterException {
        try {
            ResultSet rs = allPs.executeQuery();
            List<MyElement> elems = new ArrayList<>();
            while (rs.next()) {
                ElementType et = ElementType.valueOf(rs.getString(2));
                MyElement e = null;
                switch (et) {
                    case Rectangle: {
                        e = new MyRectangle(new MyElementId(rs.getInt(1)),
                                rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6));
                        break;
                    }
                    case Circle: {
                        e = new MyCircle(new MyElementId(rs.getInt(1)),
                                rs.getDouble(3), rs.getDouble(4), rs.getDouble(5));
                    }
                }
                elems.add(e);
            }
            return elems;
        } catch (SQLException ex) {
            Logger.getLogger(DerbyElementDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PainterException(ex);
        }

    }

    @Override
    public void clearAll() throws PainterException {
        try {
            clearAllPs.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DerbyElementDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PainterException(ex);
        }
    }

}
