/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author crist
 */

import jakarta.json.JsonObject;
import com.google.gson.Gson;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class GameService {
    protected EntityManager em;

    public GameService(EntityManager em) {
        this.em = em;
    }
    
    public String createGame(int id, String description, String console, 
            float price, String title, String type, String storeAdress){
        if(findGame(id) != null){ 
            Game g = new Game(id);
            g.setDescription(description);
            g.setConsole(console);
            g.setPrice(price);
            g.setTitle(title);
            g.setType(type);
            g.setStoreAdress(storeAdress);
            em.persist(g);  //Aqui metemos al juego en la parte de persistencia. Aun no esta en la BD
            return "HTTP 201 Created";
        }
        //Si el juego ya existe devolvemos este codigo de error.
        return "HTTP 409 Conflict";
    }
    
    
    public String createGameFromJson(JsonObject Json, boolean autenticat){
        
        if(findGame(Json.getInt("id")) != null && autenticat){ 
            Game g = new Game(Json.getInt("id"));
            g.setDescription(Json.getString("description"));
            g.setConsole(Json.getString("console"));
            g.setPrice(Float.parseFloat(Json.getString("price")));
            g.setTitle(Json.getString("title"));
            g.setType(Json.getString("type"));
            g.setStoreAdress(Json.getString("storeAdress"));
            em.persist(g);  //Aqui metemos al juego en la parte de persistencia. Aun no esta en la BD
            return "HTTP 201 Created";
        }else if(autenticat){
            //Si el juego ya existe devolvemos este codigo de error.
            return "HTTP 409 Conflict";
        }else{
            return "HTTP 401 Unauthorized";
        }
        
        
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
    
    //Consulta si se piden todos los juegos sin un tipo, simplemente orden alfabetico
    public String findAllGamesAlphabeticalOrder(){
        Query query = em.createQuery("SELECT e FROM Game e ORDER BY e.name ASC");
        Collection<Game> games = (Collection<Game>)query.getResultList();
        
        Gson gson = new Gson();
        String json = gson.toJson(games);
        return json;
    }
    
    //Consulta opcional si se piden todos los juegos de un tipo especifico + orden alfabetico
    public String findAllGamesAlphabeticalOrderWithType(String type) {
        Query query = em.createQuery("SELECT e FROM Game e WHERE e.type = :type ORDER BY e.name ASC");
        query.setParameter("type", type);
        Collection<Game> games = (Collection<Game>)query.getResultList();
        
        Gson gson = new Gson();
        String json = gson.toJson(games);
        return json;
    }
}
