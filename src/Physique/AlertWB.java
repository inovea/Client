/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Physique;

import Metier.Alert;
import Metier.interfaces.AlertService;
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
public class AlertWB implements AlertService{
    private WebService wb;
     public Alert getAlert(JSONObject obj) throws JSONException, ParseException{
        Alert alert = new Alert();
        alert.setIdAlert(obj.getJSONObject("alert").getInt("idAlert"));
        if(String.valueOf(obj.getJSONObject("alert").getInt("state"))!=null)
             alert.setState(obj.getJSONObject("alert").getInt("state"));
        if(String.valueOf(obj.getJSONObject("alert").getInt("author"))!=null)
             alert.setIdCourier(obj.getJSONObject("alert").getInt("author"));
        if(obj.getJSONObject("alert").getString("description")!=null)
            alert.setDescription(obj.getJSONObject("alert").getString("description"));
        if(obj.getJSONObject("alert").getString("date")!=null)
            alert.setDate(obj.getJSONObject("alert").getString("date"));
         alert.setIdContainer(obj.getJSONObject("alert").getInt("Container_idContainer"));
        return alert;
    }
    
    public List<Alert> getListAlerts(JSONObject obj) throws JSONException, ParseException{
        List<Alert> list = new ArrayList<>();
        
        JSONArray alerts = obj.getJSONArray("alert");
        for(int i =0;i<alerts.length();i++){
            Alert alert = new Alert();
            JSONObject tempAlert = alerts.getJSONObject(i);
            alert.setIdAlert(tempAlert.getInt("idAlert"));
            if(String.valueOf(tempAlert.getInt("state")) != null){
            alert.setState(tempAlert.getInt("state"));
            }
             if(tempAlert.getString("description") != null){
            alert.setDescription(tempAlert.getString("description"));
             }
             if(tempAlert.getString("date") != null){
            alert.setDate(tempAlert.getString("date"));
             }
             if(String.valueOf(tempAlert.getInt("author")) != null){
            alert.setIdCourier(tempAlert.getInt("author"));
             }
            alert.setIdContainer(tempAlert.getInt("Container_idContainer"));
            list.add(alert);
        }
      return  list;
    }
    @Override
    public Alert add(Alert alert) throws Exception {
         wb = new WebService();
        JSONObject jsonObject = wb.getElement(new URL("http://inovea.herobo.com/webhost/alert.php?tag=create&state="+alert.getState()+"&description="+alert.getDescription()+"&author="+alert.getIdCourier()+"&idContainer="+alert.getIdContainer()));
        if(jsonObject.getInt("error") != 0){
            throw new Exception("Impossible d'ajouter l'alerte");
        }

        return getAlert(jsonObject);
    }

    @Override
    public Alert update(Alert alert) throws Exception {
        wb = new WebService();
       

        JSONObject jsonObject = wb.getElement(new URL("http://inovea.herobo.com/webhost/alert.php?tag=update&idAlert="+alert.getIdAlert()+"&state="+alert.getState()+"&description="+alert.getDescription()+"&date="+alert.getDate()+"&author="+alert.getIdCourier()+"&idContainer="+alert.getIdContainer()));
        System.out.println("http://inovea.herobo.com/webhost/alert.php?tag=update&idAlert="+alert.getIdAlert()+"&state="+alert.getState()+"&description="+alert.getDescription()+"&date="+alert.getDate()+"&author="+alert.getIdCourier()+"&idContainer="+alert.getIdContainer());
        if(jsonObject.getInt("error") != 0){
            throw new Exception("Impossible de modifier l'alerte");
        }

        return getAlert(jsonObject);
    }

    @Override
    public void delete(Alert alert) throws Exception {
        wb = new WebService();
        JSONObject jsonObject = wb.getElement(new URL("http://inovea.herobo.com/webhost/alert.php?tag=delete&idAlert="+alert.getIdAlert()));
        if(jsonObject.getInt("error") != 0){
            throw new Exception("Impossible de supprimer l'alerte");
        }
    }

    @Override
    public Alert getById(int idAlert) throws Exception {
         wb = new WebService();
        JSONObject jsonObject = wb.getElement(new URL("http://inovea.herobo.com/webhost/alert.php?tag=getById&idAlert="+idAlert));
        if(jsonObject.getInt("error") != 0){
            throw new Exception("Impossible de recuperer l'alerte");
        }

        return getAlert(jsonObject);
    }

    @Override
    public List<Alert> getAll() throws Exception {
         wb = new WebService();
        JSONObject jsonObject = wb.getElement(new URL("http://inovea.herobo.com/webhost/alert.php?tag=getAll"));
        if(jsonObject.getInt("error") != 0){
            List<Alert> alerts = new ArrayList<>();
            return alerts;
            //throw new Exception("Impossible de recuperer les alertes");
        }

        return getListAlerts(jsonObject);
    }

    @Override
    public List<Alert> getByContainer(int idContainer) throws Exception {
         wb = new WebService();
        JSONObject jsonObject = wb.getElement(new URL("http://inovea.herobo.com/webhost/alert.php?tag=getByContainer&idContainer="+idContainer));
        if(jsonObject.getInt("error") != 0){
            throw new Exception("Impossible de recuperer l'alerte");
        }

        return getListAlerts(jsonObject);
    }

    @Override
    public List<Alert> getByState(int idState) throws Exception {
        wb = new WebService();
        JSONObject jsonObject = wb.getElement(new URL("http://inovea.herobo.com/webhost/alert.php?tag=getByState&state="+idState));
        if(jsonObject.getInt("error") != 0){
            throw new Exception("Impossible de recuperer l'alerte");
        }

        return getListAlerts(jsonObject);
    }
    
}
