/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Metier.Courier;
import Physique.Connexion;
import Physique.CourierWB;
import Physique.Steed;
import Physique.WebService;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Oussama
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JSONException, MalformedURLException, Exception {
        WebService wb = new WebService();
        URL url = new URL("http://inovea.herobo.com/webhost/courier.php?tag=getAll");
        JSONObject jsonObject = wb.recupAllSteed(url);
        Connexion cnx = new Connexion();
        List<Steed> steeds = new ArrayList<>();
        steeds = cnx.getAllSteed(jsonObject);
        /*CourierWB wb = new CourierWB();
        List<Courier> steeds = new ArrayList<>();
        steeds = wb.getAll();
        for (Courier steed : steeds) {
            System.out.println(steed.getName());
        }*/
    }
    
}
