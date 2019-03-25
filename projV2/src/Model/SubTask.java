package Model;

import Model.Task;
import Model.User;

public class SubTask {
    private int id;
    private String subTask;
    private User user;
    private Task task;

    public SubTask(int id, String subTask, User user, Task task) {
        this.id = id;
        this.subTask = subTask;
        this.user = user;
        this.task = task;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
