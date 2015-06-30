/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier.interfaces;


import Metier.Containers;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author Lyes Atek
 */
public interface ContainerService {
    public Containers register(String name, double lat, double lng,String address) throws Exception;
    public Containers add(Containers container) throws Exception;
    public Containers update(Containers container) throws Exception;
    public void delete(int idContainer) throws Exception;
    public Containers recupLatAndLong(String address) throws Exception;
    public Containers getById(JSONObject obj) throws Exception;
    public Containers getByIdContainers(int id) throws Exception;
    //public Courier getByMail(String mail) throws Exception;
    public List<Containers> getAll() throws Exception;
}
