/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.basicApp.dao;

import br.com.basicApp.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @date 
 * @author Eliel
 * @email eliel.floyd@bol.com.br
 *
 */

public class UserDAO extends GenericDAO {
    private static final long serialVersionUID = 1L;

    public UserDAO(){

    }
    
    public boolean isValidUserAndPassword(String name,String password) throws SQLException {
        boolean toReturn = false;
        ResultSet rs = executeQuery("SELECT * FROM APP.USERS WHERE LOGIN = ? ABD PASSWORD = ?",name,password);
        if(rs.next()) {
           toReturn = true;
        }
        rs.close();
        return toReturn;
    }
    
    public int createNewUser(User usr) throws SQLException {
        usr.setId(getNextId("USERS"));
        String query = "INSERT INTO APP.USERS (ID,NAME,LOGIN,PASSWORD) VALUES (?,?,?,?)";
        executeCommand(query, usr.getId(),usr.getName(),usr.getLogin(),usr.getPassword());
        return usr.getId();
    }
    
    public void removeUser(int idUser) throws SQLException {
        String query = "DELETE FROM APP.USERS WHERE ID = ?";
        executeCommand(query,idUser);
    }
    
    public void updateUser(User usr) throws SQLException {
        String query = "UPDATE APP.USERS SET NAME=?,LOGIN=?,PASSWORD=? WHERE ID=?";
        executeCommand(query,usr.getName(),usr.getLogin(),usr.getPassword(),usr.getId());
    }
    
    public User getUser(int idUser) throws SQLException {
        String query = "SELECT * FROM APP.USERS WHERE ID = ?";
        ResultSet rs = executeQuery(query, idUser);
        User usr = null;
        if(rs.next()){
            usr = populateUserInfo(rs);
        }
        rs.close();
        return usr;
    }

    public List<User> getAllUsers() throws SQLException {
        String query = "SELECT * FROM APP.USERS";
        ResultSet rs = executeQuery(query);
        List<User> toReturn = new LinkedList<User>();
        while(rs.next()){
            toReturn.add(populateUserInfo(rs));
        }
        rs.close();
        return toReturn;
    }
    
    private User populateUserInfo(ResultSet rs) throws SQLException {
        User toReturn = new User();
        toReturn.setId(rs.getInt("ID"));
        toReturn.setName(rs.getString("NAME"));
        toReturn.setLogin(rs.getString("LOGIN"));
        toReturn.setPassword(rs.getString("PASSWORD"));
        return toReturn;
        
    }
    
    
}
