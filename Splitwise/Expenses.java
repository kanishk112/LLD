
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class Expenses {
    private final String id;
    private final String description;
    private final double amount;
    private final User paidBy;
    private final List<Split> splits;

    public Expenses(String id, double amount, String description, User paidBy){
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.paidBy = paidBy;
        this.splits = new CopyOnWriteArrayList<>();
    }

    public void addSplit(Split split){
        splits.add(split);
    }

    public String getId(){
        return id;
    }

    public User getPaidBy(){
        return paidBy;
    }

    public String getDescription(){
        return description;
    }

    public double  getAmount(){
        return amount;
    }

    public List<Split> getSplits(){
        return splits;
    }
}
