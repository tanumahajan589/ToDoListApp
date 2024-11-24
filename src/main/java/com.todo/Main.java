package com.todo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the To-Do List Application!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Mark Task as Completed");
            System.out.println("5. View All Tasks");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    Task newTask = taskManager.addTask(description);
                    System.out.println("Task added: " + newTask);
                    break;
                case 2:
                    System.out.print("Enter task ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new description: ");
                    String newDescription = scanner.nextLine();
                    if (taskManager.updateTask(updateId, newDescription)) {
                        System.out.println("Task updated successfully.");
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter task ID to delete: ");
                    int deleteId = scanner.nextInt();
                    if (taskManager.deleteTask(deleteId)) {
                        System.out.println("Task deleted successfully.");
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter task ID to mark as completed: ");
                    int completeId = scanner.nextInt();
                    if (taskManager.markTaskAsCompleted(completeId)) {
                        System.out.println("Task marked as completed.");
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;
                case 5:
                    System.out.println("All Tasks:");
                    for (Task task : taskManager.getAllTasks()) {
                        System.out.println(task);
                    }
                    break;
                case 6:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
