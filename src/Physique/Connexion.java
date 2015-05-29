/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Physique;

import Physique.Steed;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Lyes Atek
 */
public class Connexion {
  
    private List<Steed> list = new ArrayList<Steed>();
    
    public Connexion() {
    }
    public  Steed getSteed(JSONObject obj) throws JSONException{
        Steed steed = new Steed();
        steed.setId(obj.getJSONObject("user").getLong("idCourier"));
        steed.setFirstname(obj.getJSONObject("user").getString("firstname"));
        steed.setName(obj.getJSONObject("user").getString("name"));
        steed.setMail(obj.getJSONObject("user").getString("mail"));
        steed.setScheduler(obj.getJSONObject("user").getLong("scheduler"));
        return steed;
    }
    public List<Steed> getAllSteed(JSONObject obj) throws JSONException{
      
        JSONArray steeds = obj.getJSONArray("user");
        for(int i =0;i<steeds.length();i++){
            Steed steed = new Steed();
            JSONObject tempSteed = steeds.getJSONObject(i);
           
            steed.setId(tempSteed.getLong("idCourier"));
            steed.setFirstname(tempSteed.getString("firstname"));
            steed.setName(tempSteed.getString("name"));
            steed.setMail(tempSteed.getString("mail"));
            steed.setScheduler(tempSteed.getLong("scheduler"));   
            list.add(steed);
         
        }
      return  list;
    }

    
}
