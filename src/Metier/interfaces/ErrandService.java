/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier.interfaces;

import Metier.Errand;
import java.util.List;

/**
 *
 * @author Oussama
 */
public interface ErrandService {
   // public Errand register(String name, String firstname, String mail, String password, int scheduler) throws Exception;
    public Errand add(Errand errand) throws Exception;
    public Errand update(Errand errand) throws Exception;
    public void delete(int idCourier) throws Exception;
   
    public Errand getByIdErrand(int id) throws Exception;
    public Errand getByIdCourier(String mail) throws Exception;
    public List<Errand> getAll() throws Exception;
}
