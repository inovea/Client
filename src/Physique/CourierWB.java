/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Physique;

import Metier.Courier;
import Metier.interfaces.CourierService;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author Oussama
 */
public class CourierWB implements CourierService{

    @Override
    public Courier register(String name, String firstname, String mail, String password, int scheduler) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Courier add(Courier courier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Courier update(Courier courier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public Courier getByMail(String mail) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Courier> getAll() throws Exception {
        WebService wb = new WebService();
        Connexion cnx = new Connexion();
        
        URL url = new URL("http://inovea.herobo.com/webhost/courier.php?tag=getAll");
        JSONObject jsonObject = wb.recupAllSteed(url);
        List<Steed> steeds = new ArrayList<>();
        steeds = cnx.getAllSteed(jsonObject);
        
        return null;
    }
    
}
