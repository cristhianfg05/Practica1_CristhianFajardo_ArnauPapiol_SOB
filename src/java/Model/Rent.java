/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author crist
 */
public class Rent {
    private int id;
    private int idGame;
    private String dni;
    private Date dayRented;     //Dia que se alquila el juego
    private float totalPrice;   //Precio de este alquiler
    private Date returnDate;    //Dia que tiene que devolver

    public Rent() {
    }

    public Rent(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getDayRented() {
        return dayRented;
    }

    public void setDayRented(Date dayRented) {
        this.dayRented = dayRented;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Rent{" + "id=" + id + ", idGame=" + idGame + ", dni=" + dni + ", dayRented=" + dayRented + ", totalPrice=" + totalPrice + ", returnDate=" + returnDate + '}';
    }
    
    
}
