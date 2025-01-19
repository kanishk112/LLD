
import java.util.HashSet;
import java.util.Set;

public class Publisher{
    private final Set<Topic> topics;

    public Publisher(){
        this.topics = new HashSet<>();
    }

    public void addTopic(Topic topic){
        topics.add(topic);
    }

    public void publish(Message message, Topic topic){
        if(topics.contains(topic)){
            topic.publish(message);
        } else{
            System.out.println("Topic not found");
        }
    }
}