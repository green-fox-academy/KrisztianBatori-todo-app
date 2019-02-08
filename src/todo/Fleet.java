package todo;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Created by aze on 2017.03.29..
 */
public class Fleet {
    private ArrayList<Thing> things;

    public Fleet() {
        things = new ArrayList<>();
    }

    public void add(Thing thing) {
        things.add(thing);
    }

    public void addAll(ArrayList<String> things) {
        for (String thing:
             things) {
            add(new Thing(thing));
        }
    }

    public int getTodoSize() {
        return things.size();
    }

    public boolean noTodos() {
        return getTodoSize() == 0;
    }

    public Thing getTodo(int index) {
        return things.get(index);
    }

    public void removeTodo(int index) {
        things.remove(index);
    }

    public ArrayList<String> convertTodos() {
        return (ArrayList<String>) things
                                        .stream()
                                        .map(thing -> thing.name)
                                        .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        String result = "";
        for(int i = 0; i < things.size(); i++) {
            result += (i+1) + " " + things.get(i) + "\n";
        }
        return result;
    }
}
