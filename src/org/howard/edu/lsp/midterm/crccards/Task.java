package org.howard.edu.lsp.midterm.crccards;

/**
 * Represents a Task with ID, description, and status.
 */

public class Task {
    private String taskId;
    private String description;
    private String status;

    /**
     * Constructor to initialize a Task.
     * Default status is OPEN.
     * @param taskId unique task ID
     * @param description task description
     */
    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = "OPEN";
    }

    /**
     * Returns task ID.
     * @return taskId
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * Returns description.
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns status.
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets task status.
     * If invalid, sets to UNKNOWN.
     * @param status new status
     */
    public void setStatus(String status) {
        if (status.equals("OPEN") || status.equals("IN_PROGRESS") || status.equals("COMPLETE")) {
            this.status = status;
        } else {
            this.status = "UNKNOWN";
        }
    }

    /**
     * Returns formatted string.
     * @return formatted task string
     */
    @Override
    public String toString() {
        return taskId + " " + description + " [" + status + "]";
    }
}
