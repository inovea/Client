/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Physique;

import Metier.Container;
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
public class ContainerWB implements ContainerService {
//Reception du JSONObject

    public Container getLatAndLong(JSONObject obj, String adress) throws Exception {
        Container cont = new Container();
        System.out.println("Result: " + obj.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("location").getDouble("lat"));

        //  System.out.println(obj.getJSONArray("results").getJSONObject("geometry").getJSONObject("location").getDouble("lat"));
        cont.setAddress(adress);
        System.out.println("GetLatAndLong :" + cont.getAddress());
        cont.setLat(obj.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("location").getDouble("lat"));
        cont.setLng(obj.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getJSONObject("location").getDouble("lng"));
        return cont;
    }
public List<Container> getListElements(JSONObject obj) throws JSONException, ParseException {
        List<Container> list = new ArrayList<Container>();
        JSONArray containers = obj.getJSONArray("container");
        for (int i = 0; i < containers.length(); i++) {
            Container container = new Container();
            JSONObject tempCont = containers.getJSONObject(i);
            container.setId(tempCont.getInt("idContainer"));
            System.out.println("GetListElements : " +tempCont.getString("address"));
            container.setAddress(tempCont.getString("address"));
            container.setLat(tempCont.getDouble("lat"));
            container.setLng(tempCont.getDouble("lng"));
            container.setName(tempCont.getString("name"));
            container.setState(tempCont.getInt("state"));
            container.setLastCollect(tempCont.getString("lastCollect"));
            container.setIdErrand(tempCont.getInt("Errand_idErrand"));
            list.add(i, container);
        }
        return list;
        
    }

    public List<Container> getContainersWithoutErrand(JSONObject obj) throws JSONException, ParseException {
        List<Container> list = new ArrayList<Container>();
        JSONArray containers = obj.getJSONArray("container");
        int compteur = 0;
        for (int i = 0; i < containers.length(); i++) {
            Container container = new Container();
            JSONObject tempCont = containers.getJSONObject(i);
             System.out.println(tempCont.getLong("Errand_idErrand"));
            if(tempCont.getLong("Errand_idErrand") == 1){
                container.setId(tempCont.getInt("idContainer"));
                container.setAddress(tempCont.getString("address"));
                container.setLat(tempCont.getDouble("lat"));
                container.setLng(tempCont.getDouble("lng"));
                container.setName(tempCont.getString("name"));
                container.setState(tempCont.getInt("state"));
                container.setLastCollect(tempCont.getString("lastCollect"));
                container.setIdErrand(tempCont.getInt("Errand_idErrand"));
                list.add(compteur, container);
                compteur++;
               
            }
           
        }
        return list;
        
    }
 public Container getElement(JSONObject obj) throws JSONException, ParseException {
        
        Container container = new Container();
        container.setId(obj.getJSONObject("container").getInt("idContainer"));
        container.setAddress(obj.getJSONObject("container").getString("address"));
        container.setLat(obj.getJSONObject("container").getDouble("lat"));
        container.setLng(obj.getJSONObject("container").getDouble("lng"));
        container.setName(obj.getJSONObject("container").getString("name"));
        container.setState(obj.getJSONObject("container").getInt("state"));
        container.setLastCollect(obj.getJSONObject("container").getString("lastCollect"));
        container.setIdErrand(obj.getJSONObject("container").getInt("Errand_idErrand"));
        System.out.println(container.getAddress());
        return container;

    }
   
    @Override
    public Container add(Container container) throws Exception {
        WebService wb = new WebService();
        System.out.println("http://inovea.herobo.com/webhost/container.php?tag=create&name=" + container.getName() + "&lat=" + container.getLat() + "&lng=" + container.getLng() + "&address=" + container.getAddress());
        JSONObject jsonObject = wb.addAndUpdateContainer(new URL("http://inovea.herobo.com/webhost/container.php?tag=create&name=" + container.getName() + "&lat=" + container.getLat() + "&lng=" + container.getLng() + "&address=" + container.getAddress()));
        return this.getElement(jsonObject);
    }

    @Override
    public Container update(Container container) throws Exception {
       WebService wb = new WebService();
        // System.out.println("State dans le WB : "+container.getState() );
        System.out.println("http://inovea.herobo.com/webhost/container.php?tag=update&idContainer=" + container.getId() + "&name=" + container.getName() + "&lat=" + container.getLat() + "&lng=" + container.getLng() + "+&state=" + container.getState() + "&lastCollect=0000-00-00%2000:00:00&address=" + container.getAddress() + "&idErrand=" + container.getIdErrand());
        JSONObject jsonObject = wb.addAndUpdateContainer(new URL("http://inovea.herobo.com/webhost/container.php?tag=update&idContainer=" + container.getId() + "&name=" + container.getName() + "&lat=" + container.getLat() + "&lng=" + container.getLng() + "+&state=" + container.getState() + "&lastCollect=0000-00-00%2000:00:00&address=" + container.getAddress() + "&idErrand=" + container.getIdErrand()));
        return this.getElement(jsonObject);
    }

    @Override
    public void delete(int idContainer) throws Exception {
        WebService wb = new WebService();

        JSONObject jsonObject = wb.getElement(new URL("http://inovea.herobo.com/webhost/container.php?tag=delete&idContainer=" + idContainer));

    }

    @Override
    public List<Container> getAll() throws Exception {
       WebService wb = new WebService();
        JSONObject jsonObject = wb.getListElements(new URL("http://inovea.herobo.com/webhost/container.php?tag=getAll"));

        return this.getListElements(jsonObject);
    }

    @Override
    public Container recupLatAndLong(String address) throws Exception {

        WebService wb = new WebService();

        JSONObject obj = wb.recupLatAndLong(new URL("https://maps.googleapis.com/maps/api/geocode/json?address=" + address + "&key=AIzaSyB7H3ni8L2xvycZEckSvE5lzYIKMkYYgNU"));
//  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return this.getLatAndLong(obj, address);

    }

    @Override
    public Container getByIdContainers(int id) throws Exception {
       WebService wb = new WebService();
        JSONObject jsonObject = wb.getElement(new URL("http://inovea.herobo.com/webhost/container.php?tag=getById&idContainer=" + id));
        return this.getElement(jsonObject);
    }

    @Override
    public Container register(String name, double lat, double lng, String address) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Container> getByIdErrand(int id) throws Exception {
         WebService wb = new WebService();
        JSONObject jsonObject = wb.getListElements(new URL("http://inovea.herobo.com/webhost/container.php?tag=getByErrand&idErrand=" + id));
        if(jsonObject.getInt("error") != 0){
            List<Container> cont = new ArrayList<>();
            return cont;
        }  
        return this.getListElements(jsonObject);
    }

    @Override
    public List<Container> getByState(int state) throws Exception {
       WebService wb = new WebService();
        JSONObject jsonObject = wb.getElement(new URL("http://inovea.herobo.com/webhost/container.php?tag=getByState&state=" + state));
        if(jsonObject.getInt("error") != 0){
            throw new Exception("Aucun Etat pour cette ID");
        }  
        return this.getListElements(jsonObject);
    }

    @Override
    public List<Container> getContainerWithoutErrand() throws Exception {
      WebService wb = new WebService();
        JSONObject jsonObject = wb.getListElements(new URL("http://inovea.herobo.com/webhost/container.php?tag=getAll"));
        if(jsonObject.getInt("error") != 0){
           
             List<Container> cont = new ArrayList<>();
            return cont;
        } 

       return this.getContainersWithoutErrand(jsonObject);
    }

    

}
