/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public abstract class Split {
    protected User user;
    protected double amount;

    public Split(User user){
        this.user = user;
    } 

    public abstract double getAmount();

    public void setAmount(double amount){
        this.amount = amount;
    }

    public User getUser(){
        return user;
    }
    
}
