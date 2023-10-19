/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author crist
 */

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class GameService {
    protected EntityManager em;

    public GameService(EntityManager em) {
        this.em = em;
    }
    
    public Game createGame(int id, String description, String console, 
            float price, String title, String type, String storeAdress){
        if(findGame(id) != null){ 
        Game g = new Game(id);
        g.setDescription(description);
        g.setConsole(console);
        g.setPrice(price);
        g.setTitle(title);
        g.setType(type);
        g.setStoreAdress(storeAdress);
        em.persist(g);
        return g;
        }
        return null;
    }
    
    public void deleteGame(int id){
        Game g = findGame(id);
        if(g != null){
            em.remove(g);
        }
    }
    
    public Game changePrice(float newPrice, int id){
        Game g = findGame(id);
        if(g != null){
            g.setPrice(newPrice);
        }
        return g;
    }

    public Game findGame(int id) {
        return em.find(Game.class, id);
    }
    
    public Collection<Game> findAllGamesAlphabeticalOrder(){
        Query query = em.createQuery("SELECT e FROM Game e ORDER BY e.name ASC");
        return (Collection<Game>) query.getResultList();
    }
}
