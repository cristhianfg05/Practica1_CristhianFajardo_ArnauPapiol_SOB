/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;
import javax.persistence.EntityManager;

/**
 *
 * @author crist
 */
public class RentService {
    protected EntityManager em;

    public RentService(EntityManager em) {
        this.em = em;
    }
    
    public Rent createRent(int id, int idGame, String dni, Date dayRent, Date returnDay, float totalPrice, boolean autenticat){
        if(autenticat){
            Rent r = new Rent(id);
            r.setIdGame(idGame);
            r.setDni(dni);
            r.setDayRented(dayRent);
            r.setReturnDate(returnDay);
            r.setTotalPrice(totalPrice);
            em.persist(r);
            return r;
        }
        return null;
    }
    
    public void removeRent(int id){
        Rent r = findRent(id);
        if(r != null){
            em.remove(r);
        }
    }

    private Rent findRent(int id) {
        return em.find(Rent.class, id);
    }
    
    //Retorna el alquiler si estas autenticado
    public Rent findRentAutenticat(int id, boolean autenticat) {
        if(autenticat){
            return em.find(Rent.class, id);
        }
        return null;
    }
}
