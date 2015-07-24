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
public class Container {

    private int id;
    private double lat;
    private double lng;
    private int state;
    private Date lastCollect;
    private String address;
    private int idErrand;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public Container(String name, double lat, double lng, String address) throws ParseException {
        this.lat = lat;
        this.lng = lng;
        this.name = name;
        this.setLastCollect("00-00-00 00:00:00");
        this.address = address;
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
        SimpleDateFormat formatDateJour = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        String dateFormatee = formatDateJour.format(lastCollect);

        return dateFormatee;
    }

    public void setLastCollect(String lastCollect) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        Date d;
        if (lastCollect.equals("0000-00-00 00:00:00")){
            d = sdf.parse("0001-01-01 01:00:00");
        }
        else{
             d = sdf.parse(lastCollect);
        }
            
        this.lastCollect = d;

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIdErrand() {
        return idErrand;
    }

    public void setIdErrand(int idErrand) {
        this.idErrand = idErrand;
    }

    public Container(int id, double lat, double lng, int state, Date lastCollect, String address, int idErrand) {
        this.id = id;
        this.lat = lat;
        this.lng = lng;
        this.state = state;
        this.lastCollect = lastCollect;
        this.address = address;
        this.idErrand = idErrand;
    }

    public Container() {
    }

    @Override
    public String toString() {
        return this.getName() + "Adresse : "+this.getAddress();
    }
}
