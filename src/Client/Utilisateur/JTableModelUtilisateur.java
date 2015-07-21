/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Utilisateur;

import Metier.Courier;
import Metier.MetierServiceFactory;
import Metier.interfaces.CourierService;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bentalha Oussama
 */
public class JTableModelUtilisateur extends AbstractTableModel {
    
    private List<Courier> couriers = new ArrayList<>();
    private final CourierService courierMetierService = MetierServiceFactory.getCourierService();
    
    private String[] entetes = {"Id", "Nom", "Prenom", "Mail", "Administrateur"};
    
    public JTableModelUtilisateur() throws Exception {
        super();
        couriers = courierMetierService.getAll();
    }
    
    public JTableModelUtilisateur(List<Courier> list) {
        super();
        this.couriers = list;
    }

    public JTableModelUtilisateur(Courier courier) {
        super();
        this.couriers = new ArrayList<>();
        this.couriers.add(courier);
    }
    
    @Override
    public int getRowCount() {
        return couriers.size();
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return couriers.get(rowIndex).getId();
            case 1:
                return couriers.get(rowIndex).getName();
            case 2:
                return couriers.get(rowIndex).getFirstname();
            case 3:
                return couriers.get(rowIndex).getMail();
            case 4:
                return couriers.get(rowIndex).getScheduler();
            default:
                return null;
        }
    }

    public List<Courier> getCouriers() {
        return couriers;
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
        switch(columnIndex) {
            case 0 : return false;
            default : return true;
        }
    }
    
    
    public void addCourier(Courier courier) throws Exception{
        couriers.add(courier);
        fireTableRowsInserted(couriers.size() - 1, couriers.size() - 1);
    }

}
