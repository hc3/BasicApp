/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.basicApp.model;

import br.com.basicApp.swing.SwingColumn;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


/**
 *
 * @date 
 * @author Eliel
 * @email eliel.floyd@bol.com.br
 *
 */

public class Sell implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @SwingColumn(description = "Id")
    private Integer id;
    @SwingColumn(description = "Vendor")
    private User vendor;
    @SwingColumn(description = "Date of Sale")
    private Date dataOfSale;
    @SwingColumn(description = "Total")
    private float total;
    private List<SellItem>Itens = new LinkedList<SellItem>();
    
    public Sell(){

    }

    public Sell(Integer id) {
        this.id = id;
    }

    public Sell(Integer id, User vendor, Date dataOfSale, float total) {
        this.id = id;
        this.vendor = vendor;
        this.dataOfSale = dataOfSale;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getVendor() {
        return vendor;
    }

    public void setVendor(User vendor) {
        this.vendor = vendor;
    }

    public Date getDataOfSale() {
        return dataOfSale;
    }

    public void setDataOfSale(Date dataOfSale) {
        this.dataOfSale = dataOfSale;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public List<SellItem> getItens() {
        return Itens;
    }

    public void setItens(List<SellItem> Itens) {
        this.Itens = Itens;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sell other = (Sell) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
