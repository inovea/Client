/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Container;

import Metier.Container;
import Metier.MetierServiceFactory;
import Metier.interfaces.ContainerService;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lyes Atek
 */
public class JTableModelContainer extends AbstractTableModel {

    private List<Container> container = null;
    private final ContainerService containerMetierService = MetierServiceFactory.getContainerService();

    private String[] entetes = {"Id", "Nom", "Adresse", "Latitude", "Longitude", "Etat"};

    public JTableModelContainer() throws Exception {
        super();
        container = containerMetierService.getAll();
    }

    public JTableModelContainer(List<Container> list) {
        super();
        this.container = list;
    }

    public JTableModelContainer(Container container) {
        super();
        this.container = new ArrayList<>();
        this.container.add(container);
    }

    @Override
    public int getRowCount() {
        return container.size();
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return container.get(rowIndex).getId();
            case 1:
                return container.get(rowIndex).getName();
            case 2:
                return container.get(rowIndex).getAddress();
            case 3:
                return container.get(rowIndex).getLat();
            case 4:
                return container.get(rowIndex).getLng();
            case 5:
                return container.get(rowIndex).getState();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            default:
                return Object.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return false;
            default:
                return true;
        }
    }

    public List<Container> getContainer() {
        return container;
    }
    
    
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        /*    if(aValue != null) {
         try {
         Container ctr = container.get(rowIndex);
         Container copy = (Container) container.clone();
         switch(columnIndex) {
         case 1 :
         copy.setName((String)aValue);
                        
         break;
         case 2 :
         copy.setPrenom((String)aValue);
                       
         break;
         case 3 :
         copy.setLogin((String)aValue);
                        
         }
         couriers.set(rowIndex, copy);
         } catch (Exception ex) {
         Logger.getLogger(JTableModelBibliothecaire.class.getName()).log(Level.SEVERE, null, ex);
         MetierServiceFactory.getBibliotheque().getTab().setStatut("<html><body><font color='red'>"+ex.getMessage()+"</font></body></html>", "admin");
         }
         }*/
    }

}
