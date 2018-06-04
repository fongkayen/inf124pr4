/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uci.rest.model;

/**
 *
 * @author kayen
 */
public class Plushie {
    private int plushie_id;
    private String name;
    private String description;
    private String about;
    private int price;
    private String material;
    private String in_stock;
    private int num_stock;
    private String made_in;
    
    public Plushie(){
        
    }
    
    public Plushie(int plushie_id, String name, String description, String about, int price, String material, String in_stock, int num_stock, String made_in){
        this.plushie_id = plushie_id;
        this.name = name;
        this.description = description;
        this.about = about;
        this.price = price;
        this.material = material;
        this.in_stock = in_stock;
        this.num_stock = num_stock;
        this.made_in = made_in;
    }
    
    public int getPlushie_id(){
        return plushie_id;
    }
    public void setPlushie_id(int plushie_id){
        this.plushie_id = plushie_id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getAbout(){
        return about;
    }
    public void setAbout(String about){
        this.about = about;
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public String getMaterial(){
        return material;
    }
    public void setMaterial(String material){
        this.material = material;
    }
    public String getIn_stock(){
        return in_stock;
    }
    public void setIn_stock(String in_stock){
        this.in_stock = in_stock;
    }
    public int getNum_stock(){
        return num_stock;
    }
    public void setNum_stock(int num_stock){
        this.num_stock = num_stock;
    }
    public String getMade_in(){
        return made_in;
    }
    public void setMade_in(String made_in){
        this.made_in = made_in;
    }
}
