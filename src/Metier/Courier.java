/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

/**
 *
 * @author Lyes Atek
 */
public class Courier {
    private int id;
    private String mail;
    private String password;
    private String name;
    private String firstname;
    private int scheduler; // 0 = false, 1 = true

    public Courier() {
    }
    
    public Courier(String mail, String password, String name, String firstname, int scheduler) {
        this.mail = mail;
        this.password = password;
        this.name = name;
        this.firstname = firstname;
        this.scheduler = scheduler;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getScheduler() {
        return scheduler;
    }

    public void setScheduler(int scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public String toString() {
        return this.name+" "+this.firstname;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    
    
}

