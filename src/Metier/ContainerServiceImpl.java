/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Metier.interfaces.ContainerService;
import java.util.List;
import Metier.Container;
import Physique.PhysiqueDataFactory;
import org.json.JSONObject;

/**
 *
 * @author Lyes Atek
 */
public class ContainerServiceImpl implements ContainerService{
    private ContainerService containerPhysiqueService = PhysiqueDataFactory.getContainerDataService();
    @Override
     public Container add(Container container) throws Exception {
        if(container == null){
          throw  new NullPointerException("Conteneur null");
        }
        if(container.getName().equals("")){
           throw  new Exception("Nom manquant");
        }
        if(container.getAddress().equals("")){
           throw  new Exception("Adresse manquante");
        }
        if(String.valueOf(container.getLat()).equals("")){
           throw  new Exception("Latitude manquant");
        }
        if(String.valueOf(container.getLng()).equals("")){
           throw  new Exception("Longitude manquante");
        }
        
      return containerPhysiqueService.add(container);  
     }

    @Override
    public Container update(Container container) throws Exception {
        return containerPhysiqueService.update(container);
    }

    @Override
    public void delete(int idContainer) throws Exception {
         containerPhysiqueService.delete(idContainer);
    }


@Override
    public List<Container> getAll() throws Exception {
        return containerPhysiqueService.getAll();
    }

    @Override
    public Container register(String name, double lat, double lng,String address) throws Exception {
        Double latitude ;
        Double longitude ;
 
        
        if(name.equals("")){
           throw  new Exception("Nom manquant");
        }
        if(address.equals(null)){
           throw  new Exception("Adresse manquante");
        }
        if(String.valueOf(lat).equals("")){
           throw  new Exception("Latitude manquant");
        }
        if(String.valueOf(lng).equals("")){
           throw  new Exception("Longitude manquante");
        }
        Container ctn = new Container(name,lat,lng,address);
        return containerPhysiqueService.add(ctn);
    }

    @Override
    public Container recupLatAndLong(String address) throws Exception {
        if(address.equals("")){
             throw  new Exception("adresse manquante");
        }
        return containerPhysiqueService.recupLatAndLong(address);
    }

    @Override
    public Container getByIdContainers(int id) throws Exception {
        return containerPhysiqueService.getByIdContainers(id);
    }

    @Override
    public List<Container> getByIdErrand(int id) throws Exception {
        if( String.valueOf(id).equals("")){
           throw  new Exception("Id manquant");
       }
        return containerPhysiqueService.getByIdErrand(id);
    }

    @Override
    public List<Container> getByState(int state) throws Exception {
       if( String.valueOf(state).equals("")){
           throw  new Exception("Etat manquant");
       }
       return containerPhysiqueService.getByState(state);
    }

    @Override
    public List<Container> getContainerWithoutErrand() throws Exception {
       return containerPhysiqueService.getContainerWithoutErrand();
    }

  
}
