import java.util.*;
import java.text.*;
import java.io.*;

public class PersonalAssistantSimulator {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<Integer, String> tasks = new HashMap<>();
    private static final List<String> notes = new ArrayList<>();
    private static final Random random = new Random();

    public static void main(String[] args) {
        greetUser(); // Greet the user at the start
        while (true) {
            showTime(); // Show current time every time before showing the menu
            showMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addTask();
                    break;
                case "2":
                    listTasks();
                    break;
                case "3":
                    markTaskCompleted();
                    break;
                case "4":
                    addNote();
                    break;
                case "5":
                    listNotes();
                    break;
                case "6":
                    showTime();
                    break;
                case "7":
                    tellJoke();
                    break;
                case "8":
                    showWeather();
                    break;
                case "9":
                    searchTasks();
                    break;
                case "0":
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to greet the user
    private static void greetUser() {
        System.out.println("Welcome to your Personal Assistant Simulator!");
        String username = "User"; // You can modify this to ask for the user's name
        System.out.println("Hello, " + username + "! How can I assist you today?");
    }

    // Method to show the current time
    private static void showTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println("Current Date and Time: " + dateFormat.format(date));
    }

    // Method to show the menu options
    private static void showMenu() {
        System.out.println("\nPersonal Assistant Simulator");
        System.out.println("1. Add Task");
        System.out.println("2. List Tasks");
        System.out.println("3. Mark Task as Completed");
        System.out.println("4. Add Note");
        System.out.println("5. List Notes");
        System.out.println("6. Show Time");
        System.out.println("7. Tell a Joke");
        System.out.println("8. Show Weather");
        System.out.println("9. Search Tasks");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter due date (yyyy-mm-dd): ");
        String dueDate = scanner.nextLine();
        tasks.put(tasks.size() + 1, description + " (Due: " + dueDate + ")");
        System.out.println("Task added successfully.");
    }

    private static void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("\nYour Tasks:");
            for (Map.Entry<Integer, String> task : tasks.entrySet()) {
                System.out.println("Task ID: " + task.getKey() + ", Description: " + task.getValue());
            }
        }
    }

    private static void markTaskCompleted() {
        System.out.print("Enter task ID to mark as completed: ");
        int taskId = Integer.parseInt(scanner.nextLine());
        if (tasks.containsKey(taskId)) {
            String completedTask = tasks.get(taskId) + " [Completed]";
            tasks.put(taskId, completedTask);
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Invalid task ID.");
        }
    }

    private static void addNote() {
        System.out.print("Enter your note: ");
        String note = scanner.nextLine();
        notes.add(note);
        System.out.println("Note added successfully.");
    }

    private static void listNotes() {
        if (notes.isEmpty()) {
            System.out.println("No notes available.");
        } else {
            System.out.println("\nYour Notes:");
            for (String note : notes) {
                System.out.println(note);
            }
        }
    }

    private static void tellJoke() {
        String[] jokes = {
            "Why do not skeletons fight each other? They do not have the guts.",
            "Why do not programmers like nature? It has too many bugs.",
            "Why did the developer go broke? Because he used up all his cache."
        };
        System.out.println(jokes[random.nextInt(jokes.length)]);
    }

    private static void showWeather() {
        // This is a placeholder. Normally, you would fetch weather data from an API.
        System.out.println("Today's weather: Sunny, 25°C.");
    }

    private static void searchTasks() {
        System.out.print("Enter keyword to search for tasks: ");
        String keyword = scanner.nextLine();
        boolean found = false;
        for (Map.Entry<Integer, String> task : tasks.entrySet()) {
            if (task.getValue().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("Task ID: " + task.getKey() + ", Description: " + task.getValue());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No tasks found matching the keyword.");
        }
    }
}
