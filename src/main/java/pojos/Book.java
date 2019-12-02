/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author manue
 */
public class Book {
    private List<String> author;
    private String title;
    private double price;

    public Book(List<String> author, String title, double price) {
        this.author = author;
        this.title = title;
        this.price = price;
    }

    public String getAuthor() {
        Collections.sort(author);
        String auth = "";
        for (String string : author) {
            auth+=string+", ";
        }
        return auth;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s kostet %.2f €, verfasst von: %s", title, price, getAuthor());
    }

    
}
