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
 * @author drouinjonathan
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
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        /*if(aValue != null) {
            try {
                Courier courier = couriers.get(rowIndex);
                Courier copy = (Courier) courier.clone();
                switch(columnIndex) {
                    case 1 :
                        copy.setName((String)aValue);
                        this.updateBiblio(copy);
                        break;
                    case 2 :
                        copy.setPrenom((String)aValue);
                        this.updateBiblio(copy);
                        break;
                    case 3 :
                        copy.setLogin((String)aValue);
                        this.updateBiblio(copy);
                }
                couriers.set(rowIndex, copy);
            } catch (Exception ex) {
                Logger.getLogger(JTableModelBibliothecaire.class.getName()).log(Level.SEVERE, null, ex);
                MetierServiceFactory.getBibliotheque().getTab().setStatut("<html><body><font color='red'>"+ex.getMessage()+"</font></body></html>", "admin");
            }
        }*/
    }
    
    public void addErrand(Errand errand) throws Exception{
        /*courier.setNom(courier.getName().replace("\'", "\\'"));
        courier.setFirstname(bibliothecaire.getPrenom().replace("\'", "\\'"));
        Bibliothecaire add = adherentMetierService.addBiblio(bibliothecaire);
        bibliothecaire.setNom(bibliothecaire.getNom().replace("\\'", "\'"));
        bibliothecaire.setPrenom(bibliothecaire.getPrenom().replace("\\'", "\'"));*/
        errands.add(errand);
        fireTableRowsInserted(errands.size() - 1, errands.size() - 1);
        /*if (couriers.size() > (perpage * page)) {
            couriers.remove(0);
            fireTableRowsDeleted(0, 0);
        }*/
    }
    
    /*public void addBiblio(Bibliothecaire bibliothecaire) throws Exception{
        bibliothecaire.setNom(bibliothecaire.getNom().replace("\'", "\\'"));
        bibliothecaire.setPrenom(bibliothecaire.getPrenom().replace("\'", "\\'"));
        Bibliothecaire add = adherentMetierService.addBiblio(bibliothecaire);
        bibliothecaire.setNom(bibliothecaire.getNom().replace("\\'", "\'"));
        bibliothecaire.setPrenom(bibliothecaire.getPrenom().replace("\\'", "\'"));
        couriers.add(add);
        fireTableRowsInserted(couriers.size() - 1, couriers.size() - 1);
        if (couriers.size() > (perpage * page)) {
            couriers.remove(0);
            fireTableRowsDeleted(0, 0);
        }
    }*/

    public void updateBiblio(Courier c) throws Exception {
        /*bibliothecaire.setNom(bibliothecaire.getNom().replace("\'", "\\'"));
        bibliothecaire.setPrenom(bibliothecaire.getPrenom().replace("\'", "\\'"));
        adherentMetierService.updateBiblio(bibliothecaire);
        bibliothecaire.setNom(bibliothecaire.getNom().replace("\\'", "\'"));
        bibliothecaire.setPrenom(bibliothecaire.getPrenom().replace("\\'", "\'"));
        for (int i = 0; i < couriers.size(); i++) {
            if (couriers.get(i).getId() == bibliothecaire.getId()) {
                couriers.set(i, bibliothecaire);
                fireTableRowsUpdated(i, i);
                i = couriers.size();
            }
        }
        MetierServiceFactory.getBibliotheque().getTab().actualisation();
        MetierServiceFactory.getBibliotheque().getTab().setStatut("<html><body><font color='green'>Le bibliothécaire a été modifié</font></body></html>", "admin");*/
    }
    
    /*public void removeBiblio(Bibliothecaire bibliothecaire) throws Exception {
        adherentMetierService.removeBiblio(bibliothecaire);
        for (int i = 0; i < couriers.size(); i++) {
            if (couriers.get(i).getId() == bibliothecaire.getId()) {
                couriers.remove(i);
                fireTableRowsDeleted(i, i);
                i = couriers.size();
            }
        }
        MetierServiceFactory.getBibliotheque().getTab().actualisation();
        MetierServiceFactory.getBibliotheque().getTab().setStatut("<html><body><font color='green'>Le bibliothécaire a été supprimé</font></body></html>", "admin");
    }*/
    
}
