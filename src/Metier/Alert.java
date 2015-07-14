/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Lyes Atek
 */
public class Alert {
    private int idAlert;
    private int state;
    private Date date;
    private String description;
    private int idCourier;
    private int idContainer;

    public Alert() {
    }

    public Alert(int state, String date, String description, int idCourier, int idContainer, int idAlert) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = sdf.parse(date);
        this.date = d;
        this.state = state;
        this.description = description;
        this.idCourier = idCourier;
        this.idContainer = idContainer;
        this.idAlert = idAlert;
    }

   

    public int getIdAlert() {
        return idAlert;
    }

    public int getState() {
        return state;
    }

    public void setIdAlert(int idAlert) {
        this.idAlert = idAlert;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setDate(String date) throws ParseException {
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = sdf.parse(date);
        this.date = d;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIdCourier(int idCourier) {
        this.idCourier = idCourier;
    }

    public void setIdContainer(int idContainer) {
        this.idContainer = idContainer;
    }

    public String getDate() {
         SimpleDateFormat formatDateJour = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateFormatee = formatDateJour.format(date);  
        return dateFormatee;
    }

    public String getDescription() {
        return description;
    }

    public int getIdCourier() {
        return idCourier;
    }

    public int getIdContainer() {
        return idContainer;
    }
    
}
