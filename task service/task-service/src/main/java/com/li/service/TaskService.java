package com.li.service;

import com.li.model.Task;
import com.li.model.TaskStatus;

import java.util.List;

/**
 * @author: li he
 **/
public interface TaskService {
    Task createTask(Task task, String requestRole) throws Exception;

    Task getTaskById(Long id) throws Exception;

    List<Task> getAllTask(TaskStatus status);

    Task updateTask(Long id, Task updatedTask, Long userId) throws Exception;

    void deleteTask(Long id);

    Task assignedToUser(Long userId, Long taskId) throws Exception;

    List<Task> assignedUsersTask(Long userId, TaskStatus status);

    Task completeTask(Long taskId) throws Exception;
}
