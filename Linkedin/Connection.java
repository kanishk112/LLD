
import java.sql.Timestamp;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class Connection {
    private final User user;
    private final Timestamp connectionDate;

    public Connection(User user, Timestamp connectionDate){
        this.user = user;
        this.connectionDate = connectionDate;
    }

    public User getUser(){
        return this.user;
    }

    public Timestamp getConnectionDate(){
        return this.connectionDate;
    }
}
