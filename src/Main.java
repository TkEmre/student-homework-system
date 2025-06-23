import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    private static final String TASKS_FILE = "tasks.txt";
    private static final String WISHES_FILE = "wishes.txt";
    private static final String BUDGET_FILE = "budget.txt";
    private static final String COMMANDS_FILE = "commands.txt";
    private static final TaskManager tm = new TaskManager();
    private static final WishManager wm = new WishManager();

    public static void main(String[] args) {
        processCommands();
    }

    private static void processCommands() {
        try (BufferedReader reader = new BufferedReader(new FileReader(COMMANDS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    executeCommand(line.trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading commands file: " + e.getMessage());
        }
    }

    private static void executeCommand(String input) {
        String[] parts = input.trim().split(" ");
        if (parts.length < 1) {
            System.out.println("Invalid command format.");
            return;
        }

        String command = parts[0];
        String role = parts.length > 1 ? parts[1] : "";
        String params = parts.length > 2 ? String.join(" ", Arrays.copyOfRange(parts, 2, parts.length)) : "";

        switch (command) {
            case "ADD_TASK1":
            case "ADD_TASK2":
                if (role.equals("T") || role.equals("F")) {
                    tm.addTask(params);
                } else {
                    System.out.println("Error: Students cannot add tasks.");
                }
                break;
            case "LIST_ALL_TASKS":
                tm.listTasks(params);
                break;
            case "TASK_DONE":
                if (role.equals("C")) {
                    tm.markTaskDone(params);
                } else {
                    System.out.println("Error: Only students can mark tasks as done.");
                }
                break;
            case "TASK_CHECKED":
                if (role.equals("T") || role.equals("F")) {
                    tm.checkTask(params);
                } else {
                    System.out.println("Error: Students cannot check tasks.");
                }
                break;
            case "ADD_WISH1":
            case "ADD_WISH2":
                if (role.equals("C")) {
                    wm.addWish(params);
                } else {
                    System.out.println("Error: Only students can add wishes.");
                }
                break;
            case "LIST_ALL_WISHES":
                wm.listWishes();
                break;
            case "WISH_CHECKED":
                if (role.equals("T") || role.equals("F")) {
                    wm.checkWish(params);
                } else {
                    System.out.println("Error: Students cannot check wishes.");
                }
                break;
            case "ADD_BUDGET_COIN":
                if (role.equals("T") || role.equals("F")) {
                    addBudget(params);
                } else {
                    System.out.println("Error: Students cannot add budget.");
                }
                break;
            case "PRINT_BUDGET":
                printBudget();
                break;
            case "PRINT_STATUS":
                printStatus();
                break;
            default:
                System.out.println("Invalid command.");
        }
    }

    private static void addBudget(String amount) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BUDGET_FILE, true))) {
            writer.write(amount + "\n");
            System.out.println("Budget added: " + amount);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void printBudget() {
        try {
            List<String> budgetLines = Files.readAllLines(Paths.get(BUDGET_FILE));
            int total = 0;
            for (String line : budgetLines) {
                if (line.startsWith("TASK")) {
                    String[] parts = line.split(" ");
                    total += Integer.parseInt(parts[1]); // TASK 10 5
                } else {
                    total += Integer.parseInt(line);
                }
            }
            System.out.println("Total Budget: " + total);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading budget file: " + e.getMessage());
        }
    }

    private static void printStatus() {
        try {
            List<String> budgetLines = Files.readAllLines(Paths.get("budget.txt"));
            int totalPoints = 0;

            for (String line : budgetLines) {
                if (line.startsWith("TASK")) {
                    String[] parts = line.split(" ");
                    totalPoints += Integer.parseInt(parts[1]); // TASK 10 5
                } else {
                    totalPoints += Integer.parseInt(line); // plain coin
                }
            }

            int level = 1;
            if (totalPoints > 40 && totalPoints <= 60) level = 2;
            else if (totalPoints > 60 && totalPoints <= 80) level = 3;
            else if (totalPoints > 80) level = 4;

            System.out.println("Points: " + totalPoints);
            System.out.println("Level: " + level);

        } catch (IOException e) {
            System.out.println("Error reading budget file: " + e.getMessage());
        }
    }


}
