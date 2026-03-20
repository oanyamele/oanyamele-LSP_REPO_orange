package org.howard.edu.lsp.midterm.crccards;

import java.util.*;

/**
 * Manages Task objects.
 */

public class TaskManager {
    private Map<String, Task> tasks = new HashMap<>();

    /**
     * Adds a new task.
     * Throws exception if duplicate ID.
     * @param task Task object
     */
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Duplicate task ID");
        }
        tasks.put(task.getTaskId(), task);
    }

    /**
     * Finds a task by ID.
     * @param taskId ID to search
     * @return Task or null if not found
     */
    public Task findTask(String taskId) {
        return tasks.getOrDefault(taskId, null);
    }

    /**
     * Returns tasks matching a status.
     * @param status status to filter
     * @return list of matching tasks
     */
    public List<Task> getTasksByStatus(String status) {
        List<Task> result = new ArrayList<>();

        for (Task t : tasks.values()) {
            if (t.getStatus().equals(status)) {
                result.add(t);
            }
        }

        return result;
    }
}
