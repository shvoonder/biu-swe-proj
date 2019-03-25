package Model;

public class Project {

    private Integer id;
    private String name;
    private Integer priorityId;
    private Integer userId;

    public Project(Integer id, String name, Integer priorityId, Integer userId) {
        this.id = id;
        this.name = name;
        this.priorityId = priorityId;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(Integer priorityId) {
        this.priorityId = priorityId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}