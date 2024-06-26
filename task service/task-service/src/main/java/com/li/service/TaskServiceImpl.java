package com.li.service;

import com.li.model.Task;
import com.li.model.TaskStatus;
import com.li.repository.TaskRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: li he
 **/
@Service
public class TaskServiceImpl implements TaskService{

    @Resource
    private TaskRepository taskRepository;

    @Override
    public Task createTask(Task task, String requestRole) throws Exception {
        if(!requestRole.equals("ROLE_ADMIN")){
            throw new Exception("only admin can create a task");
        }

        task.setStatus(TaskStatus.PENDING);
        task.setCreateAt(LocalDateTime.now());

        return taskRepository.save(task);
    }

    @Override
    public Task getTaskById(Long id) throws Exception {
        return taskRepository.findById(id).orElseThrow(() -> new Exception("task not found"));
    }

    @Override
    public List<Task> getAllTask(TaskStatus status) {
        List<Task> allTask = taskRepository.findAll();

        List<Task> filteredTasks = allTask.stream().filter(
                task -> status == null || task.getStatus().name().equalsIgnoreCase(status.toString())
        ).collect(Collectors.toList());
        return filteredTasks;
    }

    @Override
    public Task updateTask(Long id, Task updatedTask, Long userId) throws Exception {
        Task existingTask = getTaskById(id);

        if(updatedTask.getTitle() != null){
            existingTask.setTitle(updatedTask.getTitle());
        }
        if(updatedTask.getImage() != null){
            existingTask.setImage(updatedTask.getImage());
        }
        if(updatedTask.getDescription() != null){
            existingTask.setDescription(updatedTask.getDescription());
        }
        if(updatedTask.getStatus() != null){
            existingTask.setStatus(updatedTask.getStatus());
        }
        if(updatedTask.getDeadline() != null){
            existingTask.setDeadline(updatedTask.getDeadline());
        }
        if(updatedTask.getTags() != null){
            existingTask.setTags(updatedTask.getTags());
        }


        return taskRepository.save(existingTask);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task assignedToUser(Long userId, Long taskId) throws Exception {
        Task task = getTaskById(taskId);
        task.setAssignedUserId(userId);
        task.setStatus(TaskStatus.DONE);

        return taskRepository.save(task);
    }

    @Override
    public List<Task> assignedUsersTask(Long userId, TaskStatus status) {

        List<Task> allTask = taskRepository.findByAssignedUserId(userId);
        List<Task> filteredTasks = allTask.stream().filter(
                task -> status == null || task.getStatus().name().equalsIgnoreCase(status.toString())
        ).collect(Collectors.toList());

        return filteredTasks;
    }

    @Override
    public Task completeTask(Long taskId) throws Exception {

        Task task = getTaskById(taskId);
        task.setStatus(TaskStatus.DONE);
        return taskRepository.save(task);
    }
}
