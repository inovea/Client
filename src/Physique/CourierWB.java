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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Oussama
 */
public class CourierWB implements CourierService{
    
    private WebService wb;
    
    @Override
    public Courier register(String name, String firstname, String mail, String password, int scheduler) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Courier add(Courier courier) throws Exception {
        wb = new WebService();
        System.out.println("http://inovea.herobo.com/webhost/courier.php?tag=register&name="+courier.getName()+"&firstname="+courier.getFirstname()+"&mail="+courier.getMail()+"&password="+courier.getPassword()+"&scheduler="+courier.getScheduler());
        
        JSONObject jsonObject = wb.getElement(new URL("http://inovea.herobo.com/webhost/courier.php?tag=register&name="+courier.getName()+"&firstname="+courier.getFirstname()+"&mail="+courier.getMail()+"&password="+courier.getPassword()+"&scheduler="+courier.getScheduler()));
        if(jsonObject.getInt("error") != 0){
            if(jsonObject.getInt("error") == 2){
                throw new Exception("Utilisateur deja existant");
            }
            throw new Exception("Impossible d'ajouter l'utilisateur");
        }

        return getCourier(jsonObject);
    }

    @Override
    public Courier update(Courier courier) throws Exception {
        wb = new WebService();
        //System.out.println("http://inovea.herobo.com/webhost/courier.php?tag=update&idCourier="+courier.getId()+"&name="+courier.getName()+"&firstname="+courier.getFirstname()+"&mail="+courier.getMail()+"&scheduler="+courier.getScheduler());
        
        JSONObject jsonObject = wb.getElement(new URL("http://inovea.herobo.com/webhost/courier.php?tag=update&idCourier="+courier.getId()+"&name="+courier.getName()+"&firstname="+courier.getFirstname()+"&mail="+courier.getMail()+"&scheduler="+courier.getScheduler()));
        if(jsonObject.getInt("error") != 0){
            throw new Exception("Impossible de modifier l'utilisateur");
        }

        return getCourier(jsonObject);
    }

    @Override
    public void delete(int idCourier) throws Exception {
        wb = new WebService();        
        JSONObject jsonObject = wb.getElement(new URL("http://inovea.herobo.com/webhost/courier.php?tag=delete&idCourier="+idCourier));
        if(jsonObject.getInt("error") != 0){
            throw new Exception("Impossible de supprimer l'utilisateur");
        }
    }

    @Override
    public Courier login(String mail, String password) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Courier getById(int id) throws Exception {
        wb = new WebService();
        JSONObject jsonObject = wb.getElement(new URL("http://inovea.herobo.com/webhost/courier.php?tag=getById?idCourier="+id));
        return getCourier(jsonObject);
    }

    @Override
    public Courier getByMail(String mail) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Courier> getAll() throws Exception {
        wb = new WebService();
        List<Courier> couriers = new ArrayList<>();
        
        JSONObject jsonObject = wb.getListElements(new URL("http://inovea.herobo.com/webhost/courier.php?tag=getAll"));
        couriers = getCouriers(jsonObject);       
        return couriers;
    }
    
    public Courier getCourier(JSONObject obj) throws JSONException{
        Courier courier = new Courier();
        courier.setId(obj.getJSONObject("user").getInt("idCourier"));
        courier.setFirstname(obj.getJSONObject("user").getString("firstname"));
        courier.setName(obj.getJSONObject("user").getString("name"));
        courier.setMail(obj.getJSONObject("user").getString("mail"));
        courier.setScheduler(obj.getJSONObject("user").getInt("scheduler"));
        return courier;
    }
    
    public List<Courier> getCouriers(JSONObject obj) throws JSONException{
        List<Courier> list = new ArrayList<>();
        
        JSONArray couriers = obj.getJSONArray("user");
        for(int i =0;i<couriers.length();i++){
            Courier courier = new Courier();
            JSONObject tempSteed = couriers.getJSONObject(i);
           
            courier.setId(tempSteed.getInt("idCourier"));
            courier.setFirstname(tempSteed.getString("firstname"));
            courier.setName(tempSteed.getString("name"));
            courier.setMail(tempSteed.getString("mail"));
            courier.setScheduler(tempSteed.getInt("scheduler"));   
            list.add(courier);
         
        }
      return  list;
    }
    
}
