public class Tags {
    private final int id;
    private final String name;

    public Tags(String name) {
        this.id = generateId();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }
}
