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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int idCourier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
}
