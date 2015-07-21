/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Physique;

import Metier.interfaces.ContainerService;
import Metier.interfaces.CourierService;
import Metier.interfaces.ErrandService;
import Metier.interfaces.AlertService;

/**
 *
 * @author Bentalha Oussama
 */
public class PhysiqueDataFactory {

    private static CourierService courierService;
    private static ContainerService containerService;
    private static ErrandService errandService;
    private static AlertService alertService;
    
    private PhysiqueDataFactory() {
    }
    
    public static AlertService getAlertDataService() {
        if (alertService == null) {
            alertService = new AlertWB();
        }
        return alertService;
    }
    
    public static CourierService getCourierDataService() {
        if (courierService == null) {
            courierService = new CourierWB();
        }
        return courierService;
    }

    public static ContainerService getContainerDataService() {
        if (containerService == null) {
            containerService = new ContainerWB();
        }
        return containerService;
    }
    
    public static ErrandService getErrandDataService() {
        if (errandService == null) {
            errandService = new ErrandWB();
        }
        return errandService;
    }
}
