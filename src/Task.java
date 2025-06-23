public class Task {
    private int taskID;
    private String title;
    private String description;
    private String dueDate;
    private int points;
    private boolean status;
    private boolean isActivityTime;
    private boolean isParent;
    private String startTime;
    private String endTime;

    public Task(int taskID, String title, String description, String dueDate, String startTime, String endTime, int points, boolean status, boolean isActivityTime, boolean isParent) {
        this.taskID = taskID;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.points = points;
        this.status = status;
        this.isActivityTime = isActivityTime;
        this.isParent = isParent;
    }

    public void markAsDone() {
        if (!status) {
            this.status = true;
            System.out.println("Task " + taskID + " marked as done.");
        } else {
            System.out.println("Task " + taskID + " is already done.");
        }
    }

    public String toFileFormat() {
        return "ADD_TASK " + taskID + " \"" + title + "\" \"" + description + "\" " + dueDate + " " + startTime + (endTime != null ? " " + endTime : "") + " " + points;
    }

    public int getTaskID() {
        return taskID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public int getPoints() {
        return points;
    }

    public boolean getStatus(int taskID) {
        return status;
    }

    public boolean isActivityTime() {
        return isActivityTime;
    }

    public boolean isParent() {
        return isParent;
    }
}
