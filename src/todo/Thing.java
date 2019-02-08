package todo;

class Thing {
    public String name;

    public Thing(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
