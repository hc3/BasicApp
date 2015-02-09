/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.basicApp.swing;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @date 
 * @author Eliel
 * @email eliel.floyd@bol.com.br
 *
 */

public class MyTableModel extends DefaultTableModel {
    
    private static final long serialVersionUID = 1L;
    private final List entitysToList;
    private final Class entityClassToList;
    private List<Method> fieldToData = new LinkedList<Method>();
    private final JTable tableToControl;

    public MyTableModel(Class entityClassToList , List entitysToList , JTable tableToControl){
       super();
       this.entitysToList = entitysToList;
       this.entityClassToList = entityClassToList;
       this.tableToControl = tableToControl;
       try {
           smartAddTheColumns();
           smartAddValues();
       }catch(Exception e){
           e.printStackTrace();
       }
    }
    
    private void smartAddTheColumns() throws NoSuchMethodException {
        for(Field field : entityClassToList.getDeclaredFields()) {
            SwingColumn theAnnotation = field.getAnnotation(SwingColumn.class);
            if(theAnnotation != null){
                addColumn(theAnnotation.description());
                String methodName = "get"+field.getName().toUpperCase().charAt(0) + field.getName().substring(1);
                fieldToData.add(entityClassToList.getDeclaredMethod(methodName));
            }
        }
    }
    
    private void smartAddValues() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        
        for(Object entity : entitysToList) {
            List<Object> valuesToAdd = new LinkedList<Object>();
            
            for(Method method : fieldToData){
                valuesToAdd.add(method.invoke(entity));
            }
            
            addRow(valuesToAdd.toArray());
        }
    }
}
