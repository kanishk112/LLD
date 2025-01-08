
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskManager{
    private static TaskManager taskManager;
    private final Map<String, Tasks> tasksList;
    private final Map<String, List<Tasks>> userTasks;

    private TaskManager(){
        tasksList = new ConcurrentHashMap<>();
        userTasks = new ConcurrentHashMap<>();
    }

    public static synchronized TaskManager getInstance(){
        if(taskManager == null){
            taskManager = new TaskManager();
        }
        return taskManager;
    }

    public void createTasks(Tasks tasks){
        tasksList.put(tasks.getTaskID(), tasks);
        assignTaskToUser(tasks.getUserID(), tasks);
    }

    private void assignTaskToUser(User userID, Tasks tasks) {
        userTasks.computeIfAbsent(userID.getUserID(), k -> new CopyOnWriteArrayList<>()).add(tasks);
    }

    public void updateTaskStatus(Tasks updatedTask){
        Tasks existingTasks = tasksList.get(updatedTask.getTaskID());
        if(existingTasks != null){
            synchronized (existingTasks){
                existingTasks.setStatus(updatedTask.getStatus());
                existingTasks.setTaskName(updatedTask.getTaskName());
                existingTasks.setDescription(updatedTask.getDescription());
                existingTasks.setDueDate(updatedTask.getDueDate());
                existingTasks.setPriority(updatedTask.getPriority());
                User prevUser = existingTasks.getUserID();
                User newUser = updatedTask.getUserID();
                if(!prevUser.equals(newUser)){
                    userTasks.get(prevUser.getUserID()).remove(existingTasks);
                    assignTaskToUser(newUser, existingTasks);
                }
            }
        }
    }

    public void deleteTask(String taskID){
        Tasks tasks = tasksList.get(taskID);
        if(tasks != null){
            synchronized (tasks){
                userTasks.get(tasks.getUserID().getUserID()).remove(tasks);
                System.out.println("Task " + taskID + " deleted");
                tasksList.remove(taskID);
            }
        }
    }

    public List<Tasks> searchUserTasks(String keyword){
        List<Tasks> matchingTasks = new ArrayList<>();
        for(Tasks tasks : tasksList.values()){
            if(tasks.getTaskName().contains(keyword) || tasks.getDescription().contains(keyword)){
                matchingTasks.add(tasks);
            }
        }
        return matchingTasks;
    }

    public List<Tasks> filterTasks(TaskStatus status, Date startDate, Date endDate, int priority){
        List<Tasks> filteredTasks = new ArrayList<>();
        for(Tasks tasks : tasksList.values()){
            if(tasks.getStatus() == status && 
                    tasks.getDueDate().compareTo(startDate) >= 0 && 
                    tasks.getDueDate().compareTo(endDate) <= 0 && 
                    tasks.getPriority() == priority){
                filteredTasks.add(tasks);
            }
        }
        return filteredTasks;
    }

    public void markTaksAsCompleted(String taskID){
        Tasks tasks = tasksList.get(taskID);
        if(tasks != null){
            synchronized (tasks){
                tasks.setStatus(TaskStatus.COMPLETED);
            }
        }
    }

    public List<Tasks> getTasksHistory(User userID){
        return new ArrayList<>(userTasks.getOrDefault(userID.getUserID(), new ArrayList<>()));
    }

    public void assignTaskToUser(Tasks taskID, User user){
        userTasks.computeIfAbsent(user.getUserID(), k -> new CopyOnWriteArrayList<>()).add(taskID);
    }

    public void removeTaskFromUser(Tasks taskID, User user){
        List<Tasks> tasks = userTasks.get(user.getUserID());
        if(tasks != null){
            tasks.remove(taskID);
        }
    }
}