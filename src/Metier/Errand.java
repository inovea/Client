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
public class Errand {

    private int idErrand;
    private int state;
    private Date dateDebut;
    private Date dateFin;
    private double duree;
    private double distance;
    private int idCourier;

    public Errand() {
    }

    public Errand(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public long getIdErrand() {
        return idErrand;
    }

    public int getState() {
        return state;
    }

    public void setIdErrand(int idErrand) {
        this.idErrand = idErrand;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setDuree(double duree) {
        this.duree = duree;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setIdCourier(int idCourier) {
        this.idCourier = idCourier;
    }

    public double getDuree() {
        return duree;
    }

    public double getDistance() {
        return distance;
    }

    public int getIdCourier() {
        return idCourier;
    }

    public void setDateDebut(String dateDebut) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        Date d = sdf.parse(dateDebut);
        this.dateDebut = d;
    }

    public String getDateDebut() {
        SimpleDateFormat formatDateJour = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        String dateFormatee = formatDateJour.format(dateDebut);

        return dateFormatee;
    }

    public void setDateFin(String dateFin) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        Date d = sdf.parse(dateFin);
        this.dateFin = d;
    }

    public String getDateFin() {
        SimpleDateFormat formatDateJour = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        String dateFormatee = formatDateJour.format(dateFin);

        return dateFormatee;
    }

}
