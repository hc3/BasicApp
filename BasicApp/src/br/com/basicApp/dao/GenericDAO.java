/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.basicApp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @date 
 * @author Eliel
 * @email eliel.floyd@bol.com.br
 *
 */

public abstract class GenericDAO {
    private static final long serialVersionUID = 1L;

    private String driver = "com.mysql.jdbc.Driver";
    private String bd = "jdbc:mysql://localhost:3306/app";
    private String user = "root";
    private String password = "root";
    
    public Connection getConnection(){
        try{
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(bd , user , password);
            return conn;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public Statement getStatement() throws SQLException {
        return getConnection().createStatement();
    }
    
    public PreparedStatement getStatement(String st) throws SQLException {
        return getConnection().prepareStatement(st);
    }
    
    public ResultSet executeQuery(String query , Object... params) throws SQLException {
        PreparedStatement ps = getStatement(query);
        for (int i = 0; i < params.length; i++){
            ps.setObject(i+1, params[i]);
        }
        return ps.executeQuery();
    }
    
    public int executeCommand(String query , Object... params) throws SQLException {
        PreparedStatement ps = getStatement(query);
        for (int i = 0; i < params.length; i++){
            try{
                ps.setObject(i+1,params[i]);
            }catch(Exception e) {
                System.out.println("Error to try"+i+"with value"+params[i]);
            }
        }
        int result = ps.executeUpdate();
        ps.close();
        return result;
    }
    
    public Integer getNextId(String tableName) throws SQLException {
        ResultSet rs = executeQuery("select MAX(ID) from APP."+tableName);
        rs.next();
        Object result = rs.getObject(1);
        if (result == null){
            rs.close();
            return 1;
        }else {
            return ((Integer)result)+1;
        }
    }
}
