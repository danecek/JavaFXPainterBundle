/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mu.derby;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.jdbc.EmbeddedDriver;
import org.mu.integration.DAOFactory;
import org.mu.integration.ElementDAO;

/**
 *
 * @author Administrator
 */
public class DerbyDAOFactory extends DAOFactory {

    Connection conn;
    private static final Logger LOG = Logger.getLogger(DerbyDAOFactory.class.getName());

    public DerbyDAOFactory() {
       try {
            new EmbeddedDriver();
            String url = "jdbc:derby:" + System.getProperty("user.home") + "/libraryDB; create=true";
            conn = DriverManager.getConnection(url);
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rs = dbmd.getTables(null, null, "ELEMENTS", null);
            if (!rs.next()) {
                LOG.info("CREATE TABLE ELEMENTS");
                Statement stm = conn.createStatement();
                stm.executeUpdate("CREATE TABLE ELEMENTS"
                        + "(ID INT NOT NULL GENERATED ALWAYS AS IDENTITY,"
                        + "TYPE  VARCHAR(20),"
                        + "X  FLOAT,"
                        + "Y  FLOAT,"
                        + "V1  FLOAT,"
                        + "V2  FLOAT,"
                        + "PRIMARY KEY (ID))");
                
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }

    @Override
    public ElementDAO getElementDAO() {
        return new DerbyElementDAO(conn);
    }

}
