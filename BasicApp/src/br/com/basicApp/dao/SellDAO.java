/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.basicApp.dao;

import br.com.basicApp.model.Sell;
import br.com.basicApp.model.SellItem;
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

public class SellDAO extends GenericDAO {
    private static final long serialVersionUID = 1L;

    public SellDAO(){

    }
    
    public int addSell(Sell sl , boolean cascade) throws SQLException {
        sl.setId(getNextId("SELL"));
        String query = "INSERT INTO APP.SELL (ID,ID_USER,DATEOFSALE,TOTAL) VALUES (?,?,?,?)";
        //sum the total of sell
        float totalOfSale = 0f;
        for(SellItem item : sl.getItens()){
            totalOfSale += item.getPorduct().getPrice() * item.getQnt();
        }
        //create the sell in database
        executeCommand(query,sl.getId(),sl.getVendor().getId(),sl.getDataOfSale(),totalOfSale);
        if(cascade) {
            //persist the itens
            for (SellItem item : sl.getItens()){
                addSellItem(item);
            }
        }
        return sl.getId();
    }
    
    public int addSellItem(SellItem sli) throws SQLException {
        sli.setId(getNextId("SELLITEM"));
        String query = "INSERT INTO APP.SELLITEM (ID,QNT_SELLITEM,ID_PRODUCT,ID_SELL) VALUES (?,?,?,?)";
        executeCommand(query,sli.getId(),sli.getQnt(),sli.getPorduct().getId(),sli.getSell().getId());
        return sli.getId();
    }
    
    public void updateSell(Sell sl,boolean cascade) throws SQLException {
        String query = "UPDATE APP.SELL SET ID_VENDOR=?,TOTAL=? WHERE ID = ?";
        //sum the total of sell
        float totalOfSale = 0f;
        for (SellItem item : sl.getItens()) {
            totalOfSale += item.getPorduct().getPrice() * item.getQnt();
        }
        executeCommand(query,sl.getVendor().getId(),totalOfSale,sl.getId());
        if(cascade){
            for(SellItem item : sl.getItens()){
                updateSellItem(item);
            }
        }
    }
    
    public void updateSellItem(SellItem sli) throws SQLException {
        String query = "UPDATE APP.SELLITEM SET ID_PRODUCT = ?, QNT = ? WHERE ID = ?";
        executeCommand(query,sli.getPorduct().getId(),sli.getQnt(),sli.getId());
    }
    
    public void removeSell(int idSell) throws SQLException {
        executeCommand("DELETE FROM APP.SELLITEM WHERE ID_SELL = ? ", idSell);
        executeCommand("DELETE FROM APP.SELL WHERE ID = ?",idSell);
    }
    
    public void removeSellItem(int idSellItem) throws SQLException {
        executeCommand("DELETE FROM APP.SELLITEM WHERE ID = ?",idSellItem);
    }
    
    public Sell getSell(int idSell) throws SQLException {
        ResultSet rs = executeQuery("SELECT * FROM APP.SELL WHERE ID = ?",idSell);
        Sell sl = null;
        if(rs.next()){
            sl = populateSell(rs,true);
        }
        rs.close();
        return sl;
    }
    
    public List<Sell> getAllSells() throws SQLException {
        ResultSet rs = executeQuery("SELECT * FROM APP.SELL");
        List<Sell> toReturn = new LinkedList<Sell>();
        while(rs.next()){
            toReturn.add(populateSell(rs,true));
        }
        rs.close();
        return toReturn;
    }
    
    public Sell populateSell(ResultSet rs , boolean populateItens) throws SQLException {
        Sell toReturn = new Sell();
        UserDAO userDAO = new UserDAO();
        toReturn.setId(rs.getInt("ID"));
        toReturn.setVendor(userDAO.getUser(rs.getInt("ID_USER")));
        toReturn.setDataOfSale(rs.getDate("DATEOFSALE"));
        toReturn.setTotal(rs.getFloat("TOTAL"));
        if(populateItens){
            toReturn.setItens(getSellItens(toReturn));
        }
        return toReturn;
    }
    
    public SellItem getSellItem (int idSellItem) throws SQLException {
        ResultSet rs = executeQuery("SELECT * FROM APP.SELLITEM WHERE ID = ? ",idSellItem);
        SellItem sli = null;
        if(rs.next()){
            sli = populateSellItem(rs);
        }
        rs.close();
        return sli;
    }
    
    public List<SellItem> getSellItens(Sell sl) throws SQLException {
        List<SellItem> toReturn = new LinkedList<SellItem>();
        ResultSet rs = executeQuery("SELECT * FROM APP.SELLITEM WHERE ID_SELL = ?",sl.getId());
        while(rs.next()){
            toReturn.add(populateSellItem(rs,sl));
        }
        rs.close();
        return toReturn;
    }
    
    public SellItem populateSellItem(ResultSet rs , Sell... sell) throws SQLException {
        SellItem toReturn = new SellItem();
        ProductDAO prodDAO = new ProductDAO();
        toReturn.setId(rs.getInt("ID"));
        toReturn.setQnt(rs.getInt("QNT_SELLITEM"));
        toReturn.setPorduct(prodDAO.getProduct(rs.getInt("ID_PRODUCT")));
        if(sell != null && sell.length > 0){
            toReturn.setSell(sell[0]);
        }else {
            toReturn.setSell(getSell(rs.getInt("ID_SELL")));
        }
        return toReturn;
    }
}
