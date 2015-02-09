/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.basicApp.model;

import br.com.basicApp.swing.SwingColumn;
import java.util.Objects;


/**
 *
 * @date 
 * @author Eliel
 * @email eliel.floyd@bol.com.br
 *
 */

public class SellItem implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    @SwingColumn(description = "Product")
    private Product porduct;
    private Sell sell;
    @SwingColumn(description = "Qnt")
    private int qnt;
    @SwingColumn(description = "Total")
    private float totalOfItem;
    
    public SellItem(){

    }

    public SellItem(Product porduct) {
        this.porduct = porduct;
    }

    public SellItem(Product porduct, Sell sell, int qnt, float totalOfItem) {
        this.porduct = porduct;
        this.sell = sell;
        this.qnt = qnt;
        this.totalOfItem = totalOfItem;
    }

    public Product getPorduct() {
        return porduct;
    }

    public void setPorduct(Product porduct) {
        this.porduct = porduct;
    }

    public Sell getSell() {
        return sell;
    }

    public void setSell(Sell sell) {
        this.sell = sell;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final SellItem other = (SellItem) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    

    public float getTotalOfItem() {
        if(getPorduct() != null) {
        return getPorduct().getPrice()*getQnt();
        }
        return totalOfItem;
    }

    public void setTotalOfItem(float totalOfItem) {
        this.totalOfItem = totalOfItem;
    }
    
    
}
