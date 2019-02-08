package todo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        if (args.length != 0) {

            ArrayList<String> todos = new ArrayList<>();
            String filePath = "../KrisztianBatori-todo-app/src/tasks.txt";

            try {
                todos = (ArrayList<String>)Files.readAllLines(Paths.get(filePath));
            } catch (Exception e) {
                System.out.println("ToDo list can't be opened! 😱");
            }

            switch (args[0]) {
                case "-l":
                    if (todos.isEmpty()) {
                        System.out.println("No todos for today! :)");
                    }
                    else {
                        for (int i = 0; i < todos.size(); i++) {
                            System.out.println((i + 1) + " - " + todos.get(i));
                        }
                    }
                    break;
                case "-a":
                    if (args.length < 2) {
                        System.out.println("Unable to add: no task provided");
                    }
                    else {
                        todos.add(args[1]);
                        writeFile(filePath, todos, "Couldn't add new task! 😱");
                    }
                    break;
                case "-r":
                    if (args.length < 2) {
                        System.out.println("Unable to remove: no index provided");
                    }
                    else {
                        try {
                            int taskIndex = Integer.parseInt(args[1]);
                            todos.remove(taskIndex - 1);
                            writeFile(filePath, todos, "Couldn't remove task! 😱");
                        } catch (NumberFormatException e) {
                            System.out.println("Unable to remove: index is not a number");
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Unable to remove: index is out of bound");
                        }
                    }
                    break;
                default:
                    System.out.println("Unsupported argument");
                    break;
            }

        }
        else {
            System.out.println("Command Line Todo application");
            System.out.println("=============================");
            System.out.println();
            System.out.println("Command line arguments:");
            System.out.println(" -l   Lists all the tasks");
            System.out.println(" -a   Adds a new task");
            System.out.println(" -r   Removes a task");
            System.out.println(" -c   Completes a task");
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
