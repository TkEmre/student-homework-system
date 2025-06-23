import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
public class WishManager{
    private static final String WISHES_FILE = "wishes.txt";
    private List<Wish> wishList;
    public WishManager(){
        this.wishList = new ArrayList<>();
    }
    public static void addWish(String params) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(WISHES_FILE, true))) {
            writer.write(params + "\n");
            System.out.println("Wish added successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    public static void listWishes() {
        try {
            List<String> wishes = Files.readAllLines(Paths.get(WISHES_FILE));
            for (String wish : wishes) {
                System.out.println(wish);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void checkWish(String params) {
        System.out.println("Wish status updated: " + params);
    }
}