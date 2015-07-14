/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;
import Metier.interfaces.AlertService;
import Physique.PhysiqueDataFactory;
import java.util.List;
/**
 *
 * @author Lyes Atek
 */
public class AlertServiceImpl implements AlertService{
     private AlertService alertPhysiqueService = PhysiqueDataFactory.getAlertDataService();
 
    @Override
    public Alert add(Alert alert) throws Exception {
         if (alert == null) {
            throw new NullPointerException("Alert null !");
        }
        if (String.valueOf(alert.getState()).equals(null) || alert.getDescription().equals("") || String.valueOf(alert.getIdContainer()).equals(null)||String.valueOf(alert.getIdCourier()).equals(null)) {
            throw new Exception("Attention un champs n'est pas renseigné");
        }
        return alertPhysiqueService.add(alert);
    }

    @Override
    public Alert update(Alert alert) throws Exception {
        if (alert == null) {
            throw new NullPointerException("Alert null !");
        }
        return alertPhysiqueService.update(alert);
    }

    @Override
    public void delete(Alert alert) throws Exception {
       if (alert == null) {
            throw new NullPointerException("Alert null !");
        } 
       alertPhysiqueService.delete(alert);
    }

    @Override
    public Alert getById(int idAlert) throws Exception {
       if (String.valueOf(idAlert) == null) {
            throw new NullPointerException("id manquant !");
        } 
       return alertPhysiqueService.getById(idAlert);
    }

    @Override
    public List<Alert> getAll() throws Exception {
       return alertPhysiqueService.getAll();
    }

    @Override
    public List<Alert> getByContainer(int idContainer) throws Exception {
         if (String.valueOf(idContainer) == null) {
            throw new NullPointerException("id manquant !");
        } 
       return alertPhysiqueService.getByContainer(idContainer);
    }

    @Override
    public List<Alert> getByState(int idState) throws Exception {
        if (String.valueOf(idState) == null) {
            throw new NullPointerException("id manquant !");
        } 
       return alertPhysiqueService.getByState(idState);
    }
    
}
