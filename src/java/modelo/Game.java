/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
//import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 *
 * @author Cristhian y Arnau
 */

@Entity
@XmlRootElement
public class Game implements Serializable{ 
    private static final long serialVersion = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Game_Gen")
    @SequenceGenerator(name = "Game_Gen", sequenceName = "Game_Gen",initialValue = 1, allocationSize = 1)
 
    private int id;
    private String description;
    private String console;
    private boolean disponible;
    private float price;
    private String title;
    private String type;        //Solo hay 9 generos
    private String storeAdress;
    
    @OneToMany(mappedBy = "game")
    private List<Rent> rents;

    public Game() {
    }

    public Game(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStoreAdress() {
        return storeAdress;
    }

    public void setStoreAdress(String storeAdress) {
        this.storeAdress = storeAdress;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public List<Rent> getRents() {
        return rents;
    }

    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }

    
    
    @Override
    public String toString() {
        return "Game{" + "id=" + id + ", description=" + description + ", console=" + console + ", disponoble=" + disponible + ", price=" + price + ", title=" + title + ", type=" + type + ", storeAdress=" + storeAdress + '}';
    }
    
            
}
