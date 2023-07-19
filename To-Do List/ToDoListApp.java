// ToDoListApp.java
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {
    private ArrayList<Task> tasks;

    public ToDoListApp() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        tasks.add(new Task(description));
        System.out.println("Task added: " + description);
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the to-do list.");
        } else {
            System.out.println("Tasks in the to-do list:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i + ". " + tasks.get(i));
            }
        }
    }

    public void markTaskAsCompleted(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            Task task = tasks.get(taskIndex);
            task.markAsCompleted();
            System.out.println("Task marked as completed: " + task.getDescription());
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void markTaskAsIncomplete(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            Task task = tasks.get(taskIndex);
            task.markAsIncomplete();
            System.out.println("Task marked as incomplete: " + task.getDescription());
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void deleteTask(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            Task removedTask = tasks.remove(taskIndex);
            System.out.println("Task deleted: " + removedTask.getDescription());
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public static void main(String[] args) {
        ToDoListApp toDoList = new ToDoListApp();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1 - Add a new task");
            System.out.println("2 - Display tasks");
            System.out.println("3 - Mark a task as completed");
            System.out.println("4 - Mark a task as incomplete");
            System.out.println("5 - Delete a task");
            System.out.println("0 - Exit");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the new line character after reading the integer

            switch (option) {
                case 1:
                    System.out.println("Enter the task description:");
                    String description = scanner.nextLine();
                    toDoList.addTask(description);
                    break;
                case 2:
                    toDoList.displayTasks();
                    break;
                case 3:
                    System.out.println("Enter the task index to mark as completed:");
                    int completedTaskIndex = scanner.nextInt();
                    toDoList.markTaskAsCompleted(completedTaskIndex);
                    break;
                case 4:
                    System.out.println("Enter the task index to mark as incomplete:");
                    int incompleteTaskIndex = scanner.nextInt();
                    toDoList.markTaskAsIncomplete(incompleteTaskIndex);
                    break;
                case 5:
                    System.out.println("Enter the task index to delete:");
                    scanner.close();
            }
          }
        }
      }