/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Metier.interfaces.CourierService;
import Physique.CourierWB;
import Physique.PhysiqueDataFactory;
import java.util.List;

/**
 *
 * @author Oussama
 */
public class CourierServiceImpl implements CourierService{
    
    private CourierService courierPhysiqueService = PhysiqueDataFactory.getCourierDataService();
    
    @Override
    public Courier register(String name, String firstname, String mail, String password, int scheduler) throws Exception {
        return new Courier(mail, password, name, firstname, scheduler);
    }
    
    @Override
    public Courier add(Courier courier) throws Exception {
        if (courier == null) {
            throw new NullPointerException("Courier null !");
        }
        if (courier.getName().equals("") || courier.getFirstname().equals("") || courier.getPassword().equals("")) {
            throw new Exception("Attention un champs n'est pas renseigné");
        }
        if (!courier.getMail().contains("@") || !courier.getMail().contains(".")) {
            throw new Exception("Veuillez saisir une adresse mail valide");
        }
        
        Courier courierTemp = this.getByMail(courier.getMail());
        if(courierTemp.getMail().equals(courier.getMail())){
            throw new Exception(courier.toString()+" existe déjà");
        }
        
        //return courierPhysiqueService.add(courier);
        //return adherentPhysiqueService.add(adherent);
        return null;
    }

    @Override
    public Courier update(Courier courier) throws Exception {
        if (courier == null) {
            throw new NullPointerException("Courier null !");
        }
        return null;
    }

    @Override
    public void delete(int idCourier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Courier login(String mail, String password) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Courier getById(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Courier> getAll() throws Exception {
        return courierPhysiqueService.getAll();
    }

    @Override
    public Courier getByMail(String mail) throws Exception {
        if(mail.equals("")){
            throw new Exception("Aucune adresse mail renseignée");
        }
        if (!mail.contains("@") || !mail.contains(".")) {
            throw new Exception("Veuillez saisir une adresse mail valide");
        }
        //TODO
        return null;
    }

}
