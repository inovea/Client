/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Physique;

import Metier.Containers;
import Metier.interfaces.ContainerService;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Lyes Atek
 */
public class ContainerWB implements ContainerService{
//Reception du JSONObject
    public Containers getLatAndLong(JSONObject obj) throws Exception {
        Containers cont = new Containers();
                System.out.println(obj.getJSONArray("results"));
       // System.out.println(obj.getJSONArray("results")..get("location"));
        System.out.println("test");
      //  System.out.println(obj.getJSONArray("results").getJSONObject("geometry").getJSONObject("location").getDouble("lat"));
        cont.setLat(obj.getJSONObject("results").getJSONObject("geometry").getJSONObject("location").getDouble("lat"));
        cont.setLng(obj.getJSONObject("results").getJSONObject("geometry").getJSONObject("location").getDouble("lat"));
        return cont;
    }
     public List<Containers> getAllContainers(JSONObject obj) throws JSONException{
         List<Containers> list = new ArrayList<Containers>();
        JSONArray containers = obj.getJSONArray("container");
        for(int i =0;i<containers.length();i++){
            Containers container = new Containers();
            JSONObject tempCont = containers.getJSONObject(i);          
            container.setId(tempCont.getInt("idContainer"));
           // container.setAddress(tempSteed.getString("address"));
            container.setLat(tempCont.getDouble("lat"));
            container.setLng(tempCont.getDouble("lng"));
           container.setName(tempCont.getString("name"));
            container.setState(tempCont.getInt("state"));
          //  container.setLastCollect(tempSteed.getString("date"));
            container.setIdErrand(tempCont.getLong("Errand_idErrand"));
            list.add(i,container);
           
        }
      return  list;
    }
      public Containers getById(JSONObject obj) throws JSONException, ParseException{
          
          Containers container = new Containers();        
            container.setId(obj.getJSONObject("container").getInt("idContainer"));
//            container.setAddress(obj.getJSONObject("container") .getString("address"));
            container.setLat(obj.getJSONObject("container").getDouble("lat"));
            container.setLng(obj.getJSONObject("container").getDouble("lng"));
           container.setName(obj.getJSONObject("container").getString("name"));
            container.setState(obj.getJSONObject("container").getInt("state"));
//            container.setLastCollect(obj.getJSONObject("container").getString("date"));
            container.setIdErrand(obj.getJSONObject("container").getLong("Errand_idErrand"));
        return container;
    
      }
    
       
    @Override
    public Containers add(Containers container) throws Exception {
        WebServiceContainers wb = new WebServiceContainers();
       //ContainersReception cr = new ContainersReception();
        
       JSONObject jsonObject = wb.addContainer(new URL("http://inovea.herobo.com/webhost/container.php?tag=create&name="+container.getName()+"&lat="+container.getLat()+"&lng="+container.getLng()));
       return this.getById(jsonObject);
    }

    @Override
    public Containers update(Containers container) throws Exception {
       WebServiceContainers wb = new WebServiceContainers();
       
        
       JSONObject jsonObject = wb.addContainer(new URL("http://inovea.herobo.com/webhost/container.php?tag=update&idContainer="+container.getId()+"&name="+container.getName()+"&lat="+container.getLat()+"&lng="+container.getLng()+"+&state="+container.getState()+"&lastCollect="+container.getLastCollect()+"&address="+container.getAddress()+"&idErrand="+container.getIdErrand()));
       return this.getById(jsonObject);
    }

    @Override
    public void delete(int idContainer) throws Exception {
        WebServiceContainers wb = new WebServiceContainers();
       
        
       JSONObject jsonObject = wb.addContainer(new URL("http://inovea.herobo.com/webhost/container.php?tag=delete&idContainer="+idContainer));
      
    }

   

    @Override
    public List<Containers> getAll() throws Exception {
       WebServiceContainers wb = new WebServiceContainers();
       JSONObject jsonObject = wb.recupAllContainers(new URL("http://inovea.herobo.com/webhost/container.php?tag=getAll"));
      
       return this.getAllContainers(jsonObject);
    }

    @Override
    public Containers register(String name, String lat, String lng) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Containers recupLatAndLong(String address) throws Exception {
      
      WebServiceContainers wb = new WebServiceContainers();
      
      JSONObject obj = wb.recupLatAndLong(new URL("https://maps.googleapis.com/maps/api/geocode/json?address="+address+"&key=AIzaSyB7H3ni8L2xvycZEckSvE5lzYIKMkYYgNU"));
//  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      return this.getLatAndLong(obj);
      
    }

    @Override
    public Containers getByIdContainers(int id) throws Exception {
        WebServiceContainers wb = new WebServiceContainers();
       
        
       JSONObject jsonObject = wb.addContainer(new URL("http://inovea.herobo.com/webhost/container.php?tag=getById&idContainer="+id));
       return this.getById(jsonObject);
    }

  
    
    
}
