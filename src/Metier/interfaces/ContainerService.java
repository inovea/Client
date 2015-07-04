/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier.interfaces;


import Metier.Container;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author Lyes Atek
 */
public interface ContainerService {
    public Container register(String name, double lat, double lng,String address) throws Exception;
    public Container add(Container container) throws Exception;
    public Container update(Container container) throws Exception;
    public void delete(int idContainer) throws Exception;
    public Container recupLatAndLong(String address) throws Exception;
    public Container getById(JSONObject obj) throws Exception;
    public Container getByIdContainers(int id) throws Exception;
    public List<Container> getByIdErrand(int id) throws Exception;
    //public Courier getByMail(String mail) throws Exception;
    public List<Container> getAll() throws Exception;
}
