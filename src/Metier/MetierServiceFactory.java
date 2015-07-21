/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Metier.interfaces.AlertService;
import Metier.interfaces.ContainerService;
import Metier.interfaces.CourierService;
import Metier.interfaces.ErrandService;

/**
 *
 * @author Bentalha Oussama
 */
public class MetierServiceFactory {
    
    
    private static CourierService courierService;
    private static ContainerService containerService;
    private static ErrandService errandService;
    private static AlertService alertService;
    private MetierServiceFactory() {}
   
    public static CourierService getCourierService() {
        if(courierService == null) {
            courierService = new CourierServiceImpl();
        }
        return courierService;
    }
    
    public static ContainerService getContainerService() {
        if(containerService == null) {
            containerService = new ContainerServiceImpl();
        }
        return containerService;
    }

    public static ErrandService getErrandService() {
        if(errandService == null) {
            errandService = new ErrandServiceImpl();
        }
        return errandService;
    }
    
    public static AlertService getAlertService() {
        if(alertService == null) {
            alertService = new AlertServiceImpl();
        }
        return alertService;
    }
   
}
