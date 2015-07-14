/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Metier.interfaces.CourierService;
import Metier.interfaces.ErrandService;
import Physique.PhysiqueDataFactory;
import java.util.List;

/**
 *
 * @author Lyes Atek
 */
public class ErrandServiceImpl implements ErrandService{
private ErrandService errandPhysiqueService = PhysiqueDataFactory.getErrandDataService();

    @Override
    public Errand add(Errand errand) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Errand update(Errand errand) throws Exception {
        return errandPhysiqueService.update(errand);
    }

    @Override
    public void delete(int idCourier) throws Exception {
        errandPhysiqueService.delete(idCourier);
    }

    @Override
    public Errand getByIdErrand(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Errand getByIdCourier(String mail) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Errand> getAll() throws Exception {
         return errandPhysiqueService.getAll();
    }

    @Override
    public List<Errand> getByCourier(int idCourier) throws Exception {
       if(String.valueOf(idCourier).equals("")){
           throw new Exception("L'id du Coursier est manquant");
       }
       return errandPhysiqueService.getByCourier(idCourier);
    }

    @Override
    public List<Errand> getByState(int state) throws Exception {
        if(String.valueOf(state).equals("")){
           throw new Exception("L'Etat est manquant");
       }
       return errandPhysiqueService.getByCourier(state);
    }
    
}
