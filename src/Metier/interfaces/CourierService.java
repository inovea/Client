/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier.interfaces;

import Metier.Courier;
import java.util.List;

/**
 *
 * @author Oussama
 */
public interface CourierService {
    public Courier register(String name, String firstname, String mail, String password, int scheduler) throws Exception;
    public Courier add(Courier courier) throws Exception;
    public Courier update(Courier courier) throws Exception;
    public void delete(int idCourier) throws Exception;
   
    public Courier login(String mail, String password) throws Exception;
    public Courier getById(int id) throws Exception;
    public Courier getByMail(String mail) throws Exception;
    public List<Courier> getAll() throws Exception;
}
