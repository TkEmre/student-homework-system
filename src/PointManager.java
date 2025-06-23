public class PointManager {
    private Child child;

    public PointManager(Child child) {
        this.child = child;
    }

    public void addPoint(int point, int rating) {
        child.points += point;
        child.addRating(rating);
    }

    public int getPoints() {
        return child.points;
    }

    public int getLevel() {
        return child.level;
    }

}
