package todo;

public class Main {
    public static void main(String[] args) {
        if (args.length != 0) {
            // Do stuff
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
