/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Alert;

import Client.Container.*;
import Metier.Alert;
import Metier.Container;
import Metier.MetierServiceFactory;
import Metier.interfaces.AlertService;
import Metier.interfaces.ContainerService;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lyes Atek
 */
public class JTableModelAlert extends AbstractTableModel {

    private List<Alert> alert = null;
    private final AlertService alertMetierService = MetierServiceFactory.getAlertService();

    private String[] entetes = {"Identifiant", "Conteneur", "Coursier", "Description", "Etat", "Date"};

    public JTableModelAlert() throws Exception {
        super();
        alert = alertMetierService.getAll();
    }

    public JTableModelAlert(List<Alert> list) {
        super();
        this.alert = list;
    }

    public JTableModelAlert(Alert alert) {
        super();
        this.alert = new ArrayList<>();
        this.alert.add(alert);
    }

    @Override
    public int getRowCount() {
        return alert.size();
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return alert.get(rowIndex).getIdAlert();
            case 1:
                return alert.get(rowIndex).getIdContainer();
            case 2:
                return alert.get(rowIndex).getIdCourier();
            case 3:
                return alert.get(rowIndex).getDescription();
            case 4:
                return alert.get(rowIndex).getState();
            case 5:
                return alert.get(rowIndex).getDate();
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

    public List<Alert> getAlert() {
        return alert;
    }
    
   

}
