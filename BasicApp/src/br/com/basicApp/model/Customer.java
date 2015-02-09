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

public class Customer {
    private static final long serialVersionUID = 1L;
    @SwingColumn(description = "Código")
    private Integer id;
    @SwingColumn(description = "Name")
    private String name;
    @SwingColumn(description = "Age")
    private int age;
    @SwingColumn(description = "Address")
    private String address;
    @SwingColumn(description = "Telephone")
    private String telephone;
    
    public Customer(){

    }

    public Customer(Integer id) {
        this.id = id;
    }

    public Customer(Integer id, String name, int age, String address, String telephone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.telephone = telephone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return getName();
    }
    
    
}
