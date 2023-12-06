import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String description;
    private boolean isComplete;

    public Task(String description) {
        this.description = description;
        this.isComplete = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void markComplete() {
        isComplete = true;
    }

    @Override
    public String toString() {
        return "[" + (isComplete ? "completed" : " ") + "] " + description;
    }
}

class ToDoList {
    private ArrayList<Task> tasks;

    public ToDoList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        Task task = new Task(description);
        tasks.add(task);
        System.out.println("Task added: " + task.getDescription());
    }

    public void markTaskAsComplete(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.markComplete();
            System.out.println("Task marked as complete: " + task.getDescription());
        } else {
            System.out.println("Invalid task index");
        }
    }

    public void viewTasks() {
        System.out.println("To-Do List:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task removedTask = tasks.remove(index);
            System.out.println("Task removed: " + removedTask.getDescription());
        } else {
            System.out.println("Invalid task index");
        }
    }
}

public class ToDoListApps {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTo-Do List Application");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Complete");
            System.out.println("3. View Tasks");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    toDoList.addTask(description);
                    break;

                case 2:
                    System.out.print("Enter task index to mark as complete: ");
                    int completeIndex = scanner.nextInt();
                    toDoList.markTaskAsComplete(completeIndex - 1);
                    break;

                case 3:
                    toDoList.viewTasks();
                    break;

                case 4:
                    System.out.print("Enter task index to remove: ");
                    int removeIndex = scanner.nextInt();
                    toDoList.removeTask(removeIndex - 1);
                    break;

                case 5:
                    System.out.println("Exiting To-Do List Application. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}

