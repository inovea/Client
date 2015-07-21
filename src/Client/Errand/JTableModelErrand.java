/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Errand;

import Metier.Courier;
import Metier.Errand;
import Metier.MetierServiceFactory;
import Metier.interfaces.CourierService;
import Metier.interfaces.ErrandService;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bentalha Oussama
 */
public class JTableModelErrand extends AbstractTableModel {
    
    private List<Errand> errands = new ArrayList<>();
    private final ErrandService errandMetierService = MetierServiceFactory.getErrandService();
    
    private String[] entetes = {"Id", "Date de debut", "Date de fin", "Durée", "Distance","Coursier","Etat"};
    
    public JTableModelErrand() throws Exception {
        super();
        errands = errandMetierService.getAll();
    }
    
    public JTableModelErrand(List<Errand> list) {
        super();
        this.errands = list;
    }

    public JTableModelErrand(Errand errand) {
        super();
        this.errands = new ArrayList<>();
        this.errands.add(errand);
    }
    
    @Override
    public int getRowCount() {
        return errands.size();
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return errands.get(rowIndex).getIdErrand();
            case 1:
                return errands.get(rowIndex).getDateDebut();
            case 2:
                return errands.get(rowIndex).getDateFin();
            case 3:
                return errands.get(rowIndex).getDuree();
            case 4:
                return errands.get(rowIndex).getDistance();
            case 5:
                return errands.get(rowIndex).getIdCourier();
            case 6:
                return errands.get(rowIndex).getState();
            default:
                return null;
        }
    }

    public List<Errand> getErrands() {
        return errands;
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
    
    
    public void addErrand(Errand errand) throws Exception{
        errands.add(errand);
        fireTableRowsInserted(errands.size() - 1, errands.size() - 1);
        
    }
     
}
