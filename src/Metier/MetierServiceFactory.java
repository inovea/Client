/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import Metier.interfaces.CourierService;

/**
 *
 * @author drouinjonathan
 */
public class MetierServiceFactory {
    
    
    private static CourierService courierService;
    private static Bibliotheque bibliotheque;
    
    private MetierServiceFactory() {}
    
    public static CourierService getCourierService() {
        if(courierService == null) {
            courierService = new CourierServiceImpl();
        }
        return courierService;
    }
    
    
    public static Bibliotheque getBibliotheque() {
        if(bibliotheque == null) {
            bibliotheque = new Bibliotheque();
        }
        return bibliotheque;
    }
    
}
