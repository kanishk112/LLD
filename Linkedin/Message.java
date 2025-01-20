
import java.sql.Timestamp;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class Message {
    private final String id;
    private final User sender;
    private final User receiver;
    private final String message;
    private final Timestamp sentAt;

    public Message(String id, User sender, User receiver, String message, Timestamp sentAt) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.sentAt = sentAt;
    }
}
