package Model;

public class Project {

    private int id;
    private String name;
    private int priorityId;
    private int userId;

    public Project(int id, String name, int priorityId, int userId) {
        this.id = id;
        this.name = name;
        this.priorityId = priorityId;
        this.userId = userId;
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

    public int getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(int priorityId) {
        this.priorityId = priorityId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}