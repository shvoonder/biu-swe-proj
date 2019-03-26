package Model;

public class Project {

    private int id;
    private String name;
    private PriorityType priority;
    private User user;

    public Project(int id, String name, PriorityType priority, User user) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PriorityType getPriority() {
        return priority;
    }

    public void setPriority(PriorityType priority) {
        this.priority = priority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}