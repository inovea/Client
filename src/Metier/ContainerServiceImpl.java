/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Metier.interfaces.ContainerService;
import java.util.List;
import Metier.Containers;
import Physique.PhysiqueDataFactory;
import org.json.JSONObject;

/**
 *
 * @author Lyes Atek
 */
public class ContainerServiceImpl implements ContainerService{
    private ContainerService containerPhysiqueService = PhysiqueDataFactory.getContainerDataService();
    @Override
     public Containers add(Containers container) throws Exception {
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
    public Containers update(Containers container) throws Exception {
     
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return containerPhysiqueService.update(container);
    }

    @Override
    public void delete(int idContainer) throws Exception {
         containerPhysiqueService.delete(idContainer);
    }

    @Override
    public Containers getById(JSONObject obj) throws Exception {
    return containerPhysiqueService.getById(obj);
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

@Override
    public List<Containers> getAll() throws Exception {
        return containerPhysiqueService.getAll();
    }

    @Override
    public Containers register(String name, double lat, double lng,String address) throws Exception {
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
        Containers ctn = new Containers(name,lat,lng,address);
        return containerPhysiqueService.add(ctn);
    }

    @Override
    public Containers recupLatAndLong(String address) throws Exception {
        if(address.equals("")){
             throw  new Exception("adresse manquante");
        }
        return containerPhysiqueService.recupLatAndLong(address);
//  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Containers getByIdContainers(int id) throws Exception {
        return containerPhysiqueService.getByIdContainers(id);
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Containers> getByIdErrand(int id) throws Exception {
        return containerPhysiqueService.getByIdErrand(id);
    }

  
}
