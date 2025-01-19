public class Main{
    public static void main(String[] args){
        
        Topic topic1 = new Topic("topic1");
        Topic topic2 = new Topic("topic2");
        
        Publisher publisher1 = new Publisher();
        Publisher publisher2 = new Publisher();

        Subscriber subscriber1 = new PrintSubscriber("subscriber1");
        Subscriber subscriber2 = new PrintSubscriber("subscriber2");
        Subscriber subscriber3 = new PrintSubscriber("subscriber3");

        publisher1.addTopic(topic1);
        publisher2.addTopic(topic2);

        topic1.addSubscriber(subscriber1);
        topic1.addSubscriber(subscriber2);
        topic2.addSubscriber(subscriber3);
        topic2.addSubscriber(subscriber2);

        publisher1.publish(new Message("Message1 for Topic1"), topic1);
        publisher1.publish(new Message("Message2 for Topic1"), topic1);
        publisher2.publish(new Message("Message1 for Topic2"), topic2);

        topic1.removeSubscriber(subscriber2);

        publisher1.publish(new Message("Message3 for Topic1"), topic1);
        publisher2.publish(new Message("Message2 for Topic2"), topic2);
    }
}