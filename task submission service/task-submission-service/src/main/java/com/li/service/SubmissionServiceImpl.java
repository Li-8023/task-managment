package com.li.service;

import com.li.model.Submission;
import com.li.model.TaskDto;
import com.li.repository.SubmissionRepo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: li he
 **/
@Service
public class SubmissionServiceImpl implements SubmissionService{

    @Resource
    SubmissionRepo submissionRepo;
    @Resource
    UserService userService;

    @Resource
    TaskService taskService;

    @Override
    public Submission submitTask(Long taskId, String githubLink, Long userId, String jwt) throws Exception {

        TaskDto task = taskService.getTaskById(taskId, jwt);
        if(task != null){
            Submission submission = new Submission();
            submission.setTaskId(taskId);
            submission.setUserId(userId);
            submission.setGithubLink(githubLink);
            submission.setSubmissionTime(LocalDateTime.now());
            return submissionRepo.save(submission);
        }
        throw new Exception("Task not found");
    }

    @Override
    public Submission getTaskSubmissionById(Long submissionId) throws Exception {


        return submissionRepo.findById(submissionId).orElseThrow(() -> new Exception("Task submission not found"));
    }

    @Override
    public List<Submission> getAllTaskSubmissions() {
        return submissionRepo.findAll();
    }

    @Override
    public List<Submission> getTaskSubmissionByTaskId(Long taskId) {
        return submissionRepo.findByTaskId(taskId);
    }

    @Override
    public Submission acceptOrDeclineSubmission(Long id, String status) throws Exception {
        Submission submission = getTaskSubmissionById(id);
        submission.setStatus(status);

        if(status.equals("ACCEPT")){
            taskService.completeTask(submission.getTaskId());
        }

        return submissionRepo.save(submission);
    }
}
