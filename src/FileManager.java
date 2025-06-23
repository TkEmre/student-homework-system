import java.io.*;
import java.util.*;

public class FileManager {
    private List<Task> taskList;
    private List<Wish> wishList;
    private static final String TASKS_FILE = "tasks.txt";
    private static final String WISHES_FILE = "wishes.txt";

    public FileManager() {
        this.taskList = new ArrayList<>();
        this.wishList = new ArrayList<>();
        readTasksFromFile();
        readWishesFromFile();
    }


    public void readTasksFromFile() {
        taskList.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(TASKS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ", 9);
                if (parts.length >= 9) {
                    String type = parts[0];
                    int taskID = Integer.parseInt(parts[2]);
                    String title = parts[3].replace("\"", "");
                    String description = parts[4].replace("\"", "");
                    String dueDate = parts[5];  // Son tarih
                    String startTime = parts[6];  // Başlangıç saati
                    String endTime = type.equals("ADD_TASK2") ? parts[7] : null;
                    int points = Integer.parseInt(parts[type.equals("ADD_TASK2") ? 8 : 7]);

                    // Task oluştur ve listeye ekle
                    Task task = new Task(taskID, title, description, dueDate, startTime, endTime, points, false, false, false);
                    taskList.add(task);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading tasks file: " + e.getMessage());
        }
    }

    //Dosyaya taskleri yaz
    public void writeTasksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TASKS_FILE))) {
            for (Task task : taskList) {
                writer.write(task.toFileFormat() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to tasks file: " + e.getMessage());
        }
    }

    //Dosyadan wishleri oku
    public void readWishesFromFile() {
        wishList.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(WISHES_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ", 6); // İlk 6 alanı ayır
                if (parts.length >= 4) {
                    int wishID = Integer.parseInt(parts[1].substring(1)); // W102 → 102
                    String title = parts[2].replace("\"", ""); // Başlık
                    String description = parts[3].replace("\"", ""); // Açıklama
                    String startTime = parts.length > 4 ? parts[4] : null; // Varsa başlangıç zamanı
                    String endTime = parts.length > 5 ? parts[5] : null; // Varsa bitiş zamanı

                    // Wish oluştur ve listeye ekle
                    Wish wish = new Wish(wishID, title, description, startTime, endTime);
                    wishList.add(wish);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading wishes file: " + e.getMessage());
        }
    }

    //Dosyaya wishleri yaz
    public void writeWishesToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(WISHES_FILE))) {
            for (Wish wish : wishList) {
                writer.write(wish.toFileFormat() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to wishes file: " + e.getMessage());
        }
    }
}
