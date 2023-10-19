/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author crist
 */

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class GameService {
    protected EntityManager em;

    public GameService(EntityManager em) {
        this.em = em;
    }
    
    public Game createGame(int id, String photo, String description, 
            String console, float price, String title, String type, 
            String storeAdress){
        Game g = new Game(id);
        g.setPhoto(photo);
        g.setDescription(description);
        g.setConsole(console);
        g.setPrice(price);
        g.setTitle(title);
        g.setType(type);
        g.setStoreAdress(storeAdress);
        em.persist(g);
        return g;
        
    }
}
