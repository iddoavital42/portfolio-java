 package models;

public class Task {
    private int id;
    private String description;
    private int assignedTo;
    private boolean completed;

    public Task(int id, String description, int assignedTo, boolean completed) {
        this.id = id;
        this.description = description;
        this.assignedTo = assignedTo;
        this.completed = completed;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getAssignedTo() { return assignedTo; }
    public void setAssignedTo(int assignedTo) { this.assignedTo = assignedTo; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    @Override
    public String toString() {
        return "Task [id=" + id + ", description=" + description + ", assignedTo=" + assignedTo + ", completed=" + completed + "]";
    }
}
