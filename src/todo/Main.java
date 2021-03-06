package todo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        if (args.length != 0) {

            Fleet todos = new Fleet();
            String filePath = "../KrisztianBatori-todo-app/src/tasks.txt";

            try {
                todos.addAll((ArrayList<String>) Files.readAllLines(Paths.get(filePath)));
            } catch (IOException e) {
                System.out.println("Couldn't open file! 😱");
            }

            switch (args[0]) {
                case "-l":
                    if (todos.noTodos()) {
                        System.out.println("No todos for today! :)");
                    }
                    else {
                        for (int i = 0; i < todos.getTodoSize(); i++) {
                            System.out.println((i + 1) + " - " + todos.getTodo(i));
                        }
                    }
                    break;
                case "-a":
                    if (args.length < 2) {
                        System.out.println("Unable to add: no task provided");
                    }
                    else {
                        todos.addTodo(new Thing(args[1]));
                        writeFile(filePath, todos.convertTodos(), "Couldn't add new task! 😱");
                    }
                    break;
                case "-r":
                    if (args.length < 2) {
                        System.out.println("Unable to remove: no index provided");
                    }
                    else {
                        try {
                            int taskIndex = Integer.parseInt(args[1]);
                            todos.removeTodo(taskIndex - 1);
                            writeFile(filePath, todos.convertTodos(), "Couldn't remove task! 😱");
                        } catch (NumberFormatException e) {
                            System.out.println("Unable to remove: index is not a number");
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Unable to remove: index is out of bound");
                        }
                    }
                    break;
                case "-c":
                    if (args.length < 2) {
                        System.out.println("Unable to check: no index provided");
                    }
                    else {
                        try {
                            int taskIndex = Integer.parseInt(args[1]);
                            todos.getTodo(taskIndex - 1).name = "[x] " + todos.getTodo(taskIndex - 1).name.substring(4);
                            writeFile(filePath, todos.convertTodos(), "Couldn't check task! 😱");
                        } catch (NumberFormatException e) {
                            System.out.println("Unable to check: index is not a number");
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Unable to check: index is out of bound");
                        }
                    }
                    break;
                default:
                    System.out.println("Unsupported argument");
                    break;
            }

        }
        else {
            System.out.println("Command Line Todo application\n" +
                    "=============================\n\n" +
                    "Command line arguments:\n" +
                    " -l   Lists all the tasks\n" +
                    " -a   Adds a new task\n" +
                    " -r   Removes a task\n" +
                    " -c   Completes a task");
        }
    }

    public static void writeFile(String filePath, ArrayList<String> todos, String errorMessage) {
        try {
            Files.write(Paths.get(filePath), todos);
        } catch (Exception e) {
            System.out.println(errorMessage);
        }
    }
}
