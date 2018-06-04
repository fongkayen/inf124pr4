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
public class Order {
    private int cartID;
    private int productID;
    private int price;
    private String firstName;
    private String lastName;
    private String  email;
    private String address1;
    private String address2;
    private String state;
    private String city;
    private String zipcode;
    private String phone;
    private String deliverymethod;
    private String nameoncard;
    private String cardnumber;
    private String expirymonth;
    private String expiryyear;
    private String securitycode;
    
    public Order(){
        
    }
    
    public Order(int cartID, int productID, int price, String firstName, String lastName, String email, String address1, String address2, String state, String city, 
    String zipcode, String phone, String deliverymethod, String nameoncard, String cardnumber, String expirymonth, String expiryyear, String securitycode)
    {
        this.cartID = cartID;
        this.productID = productID;
        this.price = price;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address1 =  address1;
        this.address2 = address2;
        this.state =  state;
        this.city = city;
        this.zipcode = zipcode;
        this.phone = phone;
        this.deliverymethod = deliverymethod;
        this.nameoncard = nameoncard;
        this.cardnumber = cardnumber;
        this.expirymonth = expirymonth;
        this.expiryyear = expiryyear;
        this.securitycode = securitycode;
    }
    
    public int getCartID(){
            return cartID;
    }
    public void setCartID(int cartID){
        this.cartID = cartID;
    }
    public int getProductID(){
        return productID;
    }
    public void setProductID(int productID){
        this.productID = productID;
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getAddress1(){
        return address1;
    }
    public void setAddress1(String address1){
        this.address1 =  address1;
    }
    public String getAddress2(){
        return address2;
    }
    public void setAddress2(String address2){
        this.address2 = address2;
    }
    public String getState(){
        return state;
    }
    public void setState(String state){
        this.state = state;
    }
    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city = city;
    }
    public String getZipcode(){
        return zipcode;
    }
    public void setZipcode(String zipcode){
        this.zipcode = zipcode;
    }
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getDeliverymethod(){
        return deliverymethod;
    }
    public void setDeliverymethod(String deliverymethod){
        this.deliverymethod = deliverymethod;
    }
    public String getNameoncard(){
        return nameoncard;
    }
    public void setNameoncard(String nameoncard){
        this.nameoncard =  nameoncard;
    }
    public String getCardnumber(){
        return cardnumber;
    }
    public void setCardnumber(String cardnumber){
        this.cardnumber = cardnumber;
    }
    public String getExpirymonth(){
        return expirymonth;
    }
    public void setExpirymonth(String expirymonth){
        this.expirymonth = expirymonth;
    }
    public String getExpiryyear(){
        return expiryyear;
    }
    public void setExpiryyear(String expiryyear){
        this.expiryyear = expiryyear;
    }
    public String getSecuritycode(){
        return securitycode;
    }
    public void setSecuritycode(String securitycode){
        this.securitycode = securitycode;
    }

}
