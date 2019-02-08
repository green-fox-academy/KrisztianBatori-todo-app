package todo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        if (args.length != 0) {

            ArrayList<String> todos = new ArrayList<>();

            try {
                todos = (ArrayList<String>)Files.readAllLines(Paths.get("../KrisztianBatori-todo-app/src/tasks.txt"));
            } catch (Exception e) {
                System.out.println("ToDo list can't be opened! 😱");
            }

            switch (args[0]) {
                case "-l":
                    for (int i = 0; i < todos.size(); i++) {
                        System.out.println((i + 1) + " - " + todos.get(i));
                    }
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
}
