/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Physique;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;



 
 public class WebService{
	public WebService() throws JSONException {
       
        }
        public JSONObject connexion(URL url) throws JSONException{
            JSONObject obj;
            try {
               
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");
                
                if (conn.getResponseCode() != 200) {
                    throw new RuntimeException("Failed : HTTP error code : "
                            + conn.getResponseCode());
                }
                
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (conn.getInputStream())));
                String output;
                StringBuffer str = new StringBuffer() ;
                while ((output = br.readLine()) != null) {
                    str.append(	output);   
                }
                String tempStr =  str.substring(0, (str.indexOf("<!--")));
                
              obj = new JSONObject(tempStr);
          
                
                conn.disconnect();
                  return obj;
            } catch (MalformedURLException ex) {
                Logger.getLogger(WebService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ProtocolException ex) {
                Logger.getLogger(WebService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(WebService.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                  
            obj = new JSONObject();
          
            return obj;
        }
           public JSONObject recupAllSteed(URL url) throws JSONException{
            JSONObject obj;
            try {
               
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");
                
                if (conn.getResponseCode() != 200) {
                    throw new RuntimeException("Failed : HTTP error code : "
                            + conn.getResponseCode());
                }
                
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (conn.getInputStream())));
                String output;
                StringBuffer str = new StringBuffer() ;
                while ((output = br.readLine()) != null) {
                    str.append(	output);   
                }
                String tempStr =  str.substring(0, (str.indexOf("<!--")));
                System.out.println(tempStr);
              obj = new JSONObject(tempStr);
          
                
                conn.disconnect();
                  return obj;
            } catch (MalformedURLException ex) {
                Logger.getLogger(WebService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ProtocolException ex) {
                Logger.getLogger(WebService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(WebService.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                  
            obj = new JSONObject();
          
            return obj;
        }
}


