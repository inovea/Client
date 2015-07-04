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
       
        wb = new WebService();
        List<Errand> couriers = new ArrayList<>();
        
        JSONObject jsonObject = wb.getListElements(new URL("http://inovea.herobo.com/webhost/errand.php?tag=getAll"));
        couriers = getErrands(jsonObject);       
        return couriers;
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

}
