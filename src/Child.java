import java.util.ArrayList;
import java.util.List;

class Child extends User {
    int level;
    int points;
    int budget;
    List<Integer> ratings;

    public Child(String name, int userID, String role, int level, int points, int budget) {
        super(name, userID, "child");
        this.level = level;
        this.points = points;
        this.budget = budget;
        this.ratings = new ArrayList<>();
    }

    public void addRating(int rating) {
        ratings.add(rating);

    }



}
