/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier.interfaces;
import Metier.Alert;
import java.util.List;
/**
 *
 * @author Lyes Atek
 */
public interface AlertService {
    public Alert add(Alert alert) throws Exception;
    public Alert update(Alert alert) throws Exception;
    public void delete(Alert alert) throws Exception;
    public Alert getById(int idAlert) throws Exception;
    public List<Alert> getAll() throws Exception;
    public List<Alert> getByContainer(int iContainer) throws Exception;
    public List<Alert> getByState(int idState) throws Exception;
}
