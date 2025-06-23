import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
public class TaskManager{
    private List<Task> taskList;
    private static final String TASKS_FILE = "tasks.txt";
    private static final String BUDGET_FILE = "budget.txt";
    public TaskManager(){
        this.taskList = new ArrayList<>();
    }
    public static void addTask(String params) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TASKS_FILE, true))) {
            writer.write(params + "\n");
            System.out.println("Task added successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    public static void listTasks(String filter) {
        try {
            List<String> tasks = Files.readAllLines(Paths.get(TASKS_FILE));
            for (String task : tasks) {
                if (filter.isEmpty() || task.contains(filter)) {
                    System.out.println(task);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    public static void markTaskDone(String taskId) {
        System.out.println("Task " + taskId + " marked as done (Pending approval). ");
    }
    public static void checkTask(String params) {
        String[] parts = params.split(" ");
        if (parts.length != 2) {
            System.out.println("Invalid TASK_CHECKED format.");
            return;
        }

        int rating = Integer.parseInt(parts[1]);
        int points = 10;

        String line = "TASK " + points + " " + rating;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("budget.txt", true))) {
            writer.write(line + "\n");
            System.out.println("Task checked and rated: " + params);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

}
