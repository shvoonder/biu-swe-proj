package Model;

public class Task {

    private int id;
    private String task;
    private PriorityType priority;
    private User user;
    private Project project;

    public Task(int id, String task, PriorityType priority, User user, Project project) {
        this.id = id;
        this.task = task;
        this.priority = priority;
        this.user = user;
        this.project = project;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
