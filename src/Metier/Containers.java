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
public class Containers {
    private int id;
    private double lat;
    private double lng;
    private int state;
    private Date lastCollect;
    private String address;
    private long idErrand;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public Containers(String name,double lat, double lng) throws ParseException {
        this.lat = lat;
            this.lng = lng;
        this.name = name; 
        this.setLastCollect("00/00/00 00:00:00");
    }

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getLastCollect() {      
SimpleDateFormat formatDateJour = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss"); 
String dateFormatee = formatDateJour.format(lastCollect); 

        return dateFormatee;
    }

    public void setLastCollect(String lastCollect) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yy");
        Date d = sdf.parse(lastCollect);    
        this.lastCollect = d;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getIdErrand() {
        return idErrand;
    }

    public void setIdErrand(long idErrand) {
        this.idErrand = idErrand;
    }

    public Containers(int id, double lat, double lng, int state, Date lastCollect, String address, long idErrand) {
        this.id = id;
        this.lat = lat;
        this.lng = lng;
        this.state = state;
        this.lastCollect = lastCollect;
        this.address = address;
        this.idErrand = idErrand;
    }

    public Containers() {
    }

    @Override
    public String toString() {
        return "Container{" + "id=" + id + ", lat=" + lat + ", lng=" + lng + ", state=" + state + ", lastCollect=" + lastCollect + ", address=" + address + ", idErrand=" + idErrand + '}';
    }
    
}
