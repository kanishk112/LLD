import java.util.Date;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        TaskManager taskManager = TaskManager.getInstance();

        // Create users
        User user1 = new User("1", "John Doe", "john@example.com");
        User user2 = new User("2", "Jane Smith", "jane@example.com");

        // Create tasks
        Tasks task1 = new Tasks("1", "Task 1", "Description 1", user1,new Date(), 1);
        Tasks task2 = new Tasks("2", "Task 2", "Description 2", user2,new Date(), 2);
        Tasks task3 = new Tasks("3", "Task 3", "Description 3", user1,new Date(), 1);

        // Add tasks to the task manager
        taskManager.createTasks(task1);
        taskManager.createTasks(task2);
        taskManager.createTasks(task3);

        // Update a task
        task2.setDescription("Updated description");
        taskManager.updateTaskStatus(task2);

        // Search tasks
        List<Tasks> searchResults = taskManager.searchUserTasks("Task");
        System.out.println("Search Results:");
        for (Tasks task : searchResults) {
            System.out.println(task.getTaskName());
        }

        // Filter tasks
        List<Tasks> filteredTasks = taskManager.filterTasks(TaskStatus.PENDING, new Date(0), new Date(), 1);
        System.out.println("Filtered Tasks:");
        for (Tasks task : filteredTasks) {
            System.out.println(task.getTaskName());
        }

        // Mark a task as completed
        taskManager.markTaksAsCompleted("1");

        // Get task history for a user
        List<Tasks> taskHistory = taskManager.getTasksHistory(user1);
        System.out.println("Task History for " + user1.getUserName() + ":");
        for (Tasks task : taskHistory) {
            System.out.println(task.getTaskName());
        }

        // Delete a task
        taskManager.deleteTask("3");
    }
}