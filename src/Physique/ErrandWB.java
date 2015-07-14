/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Physique;

import Metier.Errand;
import Metier.interfaces.ErrandService;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Lyes Atek
 */
public class ErrandWB implements ErrandService{
    private WebService wb;
    public Errand getErrand(JSONObject obj) throws JSONException, ParseException{
        Errand errand = new Errand();
        errand.setIdErrand(obj.getJSONObject("errand").getInt("idErrand"));
        errand.setState(obj.getJSONObject("errand").getInt("state"));
        errand.setDateDebut(obj.getJSONObject("errand").getString("dateDebut"));
        errand.setDateFin(obj.getJSONObject("errand").getString("dateFin"));
        errand.setDuree(obj.getJSONObject("errand").getDouble("duree"));
        errand.setDistance(obj.getJSONObject("errand").getDouble("distance"));
        errand.setIdCourier(obj.getJSONObject("errand").getInt("Courier_idCourier"));
         System.out.println("Courier :"+errand.getIdCourier());
       System.out.println("Date debut :"+errand.getDateDebut());
       System.out.println("Date fin :"+errand.getDateFin());
       System.out.println("Durée :"+errand.getDuree());
       System.out.println("Distance :"+errand.getDistance());
        return errand;
    }
    public List<Errand> getErrands(JSONObject obj) throws JSONException, ParseException{
        List<Errand> list = new ArrayList<>();
        
        JSONArray errands = obj.getJSONArray("errand");
        for(int i =0;i<errands.length();i++){
            Errand errand = new Errand();
            JSONObject tempErrand = errands.getJSONObject(i);
          
             errand.setIdErrand(tempErrand.getInt("idErrand"));
             errand.setState(tempErrand.getInt("state"));
             errand.setDateDebut(tempErrand.getString("dateDebut"));
             errand.setDateFin(tempErrand.getString("dateFin"));
             errand.setDuree(tempErrand.getDouble("duree"));
             errand.setDistance(tempErrand.getDouble("distance"));
             errand.setIdCourier(tempErrand.getInt("Courier_idCourier"));  
            list.add(errand);    
           
        }
      return  list;
    }
 
    @Override
    public Errand add(Errand errand) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Errand update(Errand errand) throws Exception {
       wb = new WebService();
       String tmpDateD = errand.getDateDebut().replaceAll(" ","%20");      
       String tmp = errand.getDateFin().replaceAll(" ","%20");
       JSONObject jsonObject = wb.getElement(new URL("http://inovea.herobo.com/webhost/errand.php?tag=update&idErrand="+errand.getIdErrand()+"&state="+errand.getState()+"&dateDebut="+tmpDateD+"&dateFin="+tmp+"&duree="+errand.getDuree()+"&distance="+errand.getDistance()+"&idCourier="+errand.getIdCourier()));
      errand = getErrand(jsonObject);
       
        return errand;
    }

    @Override
    public void delete(int idCourier) throws Exception {
        wb = new WebService();
       JSONObject jsonObject = wb.getElement(new URL("http://inovea.herobo.com/webhost/errand.php?tag=delete&idErrand="+idCourier));
      
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
       
        wb = new WebService();
        List<Errand> errands = new ArrayList<>();
        
        JSONObject jsonObject = wb.getListElements(new URL("http://inovea.herobo.com/webhost/errand.php?tag=getAll"));
        errands = getErrands(jsonObject);       
        return errands;
    }
    
   

    @Override
    public List<Errand> getByCourier(int idCourier) throws Exception {
        WebService wb = new WebService();
        JSONObject jsonObject = wb.getListElements(new URL("http://inovea.herobo.com/webhost/errand.php?tag=getByCourier&idCourier="+idCourier));
       System.out.println( jsonObject.get("error"));
        if(jsonObject.getInt("error") != 0){
            List<Errand> list = new ArrayList();
            return list;
        }  
        return this.getErrands(jsonObject);
    }

    @Override
    public List<Errand> getByState(int state) throws Exception {
       WebService wb = new WebService();
        JSONObject jsonObject = wb.getListElements(new URL("http://inovea.herobo.com/webhost/errand.php?tag=getbyState&state="+state));
         if(jsonObject.getInt("error") != 0){
            throw new Exception("L'etat ne retourne aucune course");
        }  
        return this.getErrands(jsonObject);
    }

}
