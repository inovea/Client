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
    public Containers register(String name, String lat, String lng) throws Exception {
        Double latitude ;
        Double longitude ;
        if(name.equals("") || lat.equals("") || lng.equals("")){
            throw new NullPointerException("Un champ n'est pas renseigné");
        }
        try {
            latitude=  Double.parseDouble(lat);
            longitude=  Double.parseDouble(lng);
        } catch (Exception e) {
            throw new Exception("La valeur n'est pas numerique");
        }
        Containers ctn = new Containers(name,latitude,longitude);
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

  
}
