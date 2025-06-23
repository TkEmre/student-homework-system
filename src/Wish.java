public class Wish {
    private int wishID;
    private String title;
    private String description;
    private String startTime;
    private String endTime;


    public Wish(int wishID, String title, String description, String startTime, String endTime) {
        this.wishID = wishID;
        this.title = title;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String toFileFormat() {
        return "W" + wishID + " \"" + title + "\" \"" + description + "\"" + (startTime != null ? " " + startTime : "") + (endTime != null ? " " + endTime : "");
    }

}
