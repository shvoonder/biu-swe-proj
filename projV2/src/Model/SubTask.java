package Model;

public class SubTask {

    private int id;
    private String subTask;
    private int priorityId;
    private int userId;
    private int taskId;

    public SubTask(int id, String subTask, int priorityId, int userId, int taskId) {
        this.id = id;
        this.subTask = subTask;
        this.priorityId = priorityId;
        this.userId = userId;
        this.taskId = taskId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubTask() {
        return subTask;
    }

    public void setSubTask(String subTask) {
        this.subTask = subTask;
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
}
