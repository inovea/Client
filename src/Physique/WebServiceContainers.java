/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Physique;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Lyes Atek
 */
public class WebServiceContainers {
     public JSONObject Container(URL url) throws JSONException{
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
    
    public JSONObject addContainer(URL url) throws JSONException{
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
                System.out.println(str);
                String tempStr =  str.substring(str.indexOf("{"),str.indexOf("<"));
                System.out.println(tempStr);
              obj = new JSONObject(tempStr);
          
                System.out.println("test");
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
     
     public JSONObject recupAllContainers(URL url) throws JSONException{
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
           System.out.println(obj);
                
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
   public JSONObject recupContainerById(URL url) throws JSONException{
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
   public JSONObject recupLatAndLong(URL url) throws JSONException{
           JSONObject obj;
            try {
               System.out.println("Je suis dans WB");
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
                String strTemp = str.toString();
                strTemp = strTemp.replaceAll(" ","");
                        
              obj = new JSONObject(strTemp);
              System.out.println("Objet : " +obj.toString());
                
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
          System.out.println("Je suis dans la merde");
            return obj;
        }
     
}
