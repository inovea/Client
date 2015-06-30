/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Metier.interfaces.ContainerService;
import Metier.interfaces.CourierService;

/**
 *
 * @author drouinjonathan
 */
public class MetierServiceFactory {
    
    
    private static CourierService courierService;
//    private static Bibliotheque bibliotheque;
    private static ContainerService containerService;
    
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
    
}
