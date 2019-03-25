package Model;

public class Task {

    private int id;
    private String task;
    private int priorityId;
    private int userId;
    private int taskId;
    private int projectId;

    public Task(int id, String task, int priorityId, int userId, int taskId, int projectId) {
        this.id = id;
        this.task = task;
        this.priorityId = priorityId;
        this.userId = userId;
        this.taskId = taskId;
        this.projectId = projectId;
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

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
}
