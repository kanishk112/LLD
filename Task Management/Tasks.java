
import java.util.Date;

public class Tasks{
    private final String taskID;
    private String taskName;
    private String description;
    private final User userID;
    private TaskStatus status;
    private Date dueDate;
    private int priority;

    public Tasks(String taskID, String taskName, String description, User userID, Date dueDate, int priority){
        this.taskID = taskID;
        this.taskName = taskName;
        this.description = description;
        this.userID = userID;
        this.status = TaskStatus.PENDING;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    public String getTaskID(){
        return taskID;
    }

    public String getTaskName(){
        return taskName;
    }

    public void setTaskName(String taskName){
        this.taskName = taskName;
    }

    public String getDescription(){
        return description;
    }

    public User getUserID(){
        return userID;
    }

    public TaskStatus getStatus(){
        return status;
    }

    public Date getDueDate(){
        return dueDate;
    }

    public int getPriority(){
        return priority;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}