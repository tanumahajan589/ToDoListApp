package com.todo;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();
    private int taskIdCounter = 1;

    public Task addTask(String description) {
        Task newTask = new Task(taskIdCounter++, description);
        tasks.add(newTask);
        return newTask;
    }

    public boolean updateTask(int id, String newDescription) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setDescription(newDescription);
                return true;
            }
        }
        return false;
    }

    public boolean deleteTask(int id) {
        return tasks.removeIf(task -> task.getId() == id);
    }

    public boolean markTaskAsCompleted(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.markAsCompleted();
                return true;
            }
        }
        return false;
    }

    public List<Task> getAllTasks() {
        return tasks;
    }
}
