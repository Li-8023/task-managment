package com.li.controller;

import com.li.model.Submission;
import com.li.model.UserDto;
import com.li.repository.SubmissionRepo;
import com.li.service.SubmissionService;
import com.li.service.SubmissionServiceImpl;
import com.li.service.TaskService;
import com.li.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: li he
 **/
@RestController
@RequestMapping("/api/submission")
public class SubmissionController {

    @Resource
    private SubmissionService submissionService;

    @Resource
    private TaskService taskService;

    @Resource
    private UserService userService;

    @PostMapping("/submitTask")
    public ResponseEntity<Submission> submitTask(
            @RequestParam Long task_id,
            @RequestParam String github_link,
            @RequestHeader("Authorization") String jwt
    )throws Exception{
        UserDto user =  userService.getUserProfile(jwt);
        Submission submission = submissionService.submitTask(task_id, github_link, user.getId(), jwt);
        return new ResponseEntity<>(submission, HttpStatus.CREATED);

    }

    @GetMapping("/getSubmissionById/{id}")
    public ResponseEntity<Submission> getSubmissionById(
            @PathVariable Long id,
            @RequestHeader("Authorization") String jwt
    )throws Exception{

        Submission submission = submissionService.getTaskSubmissionById(id);
        return new ResponseEntity<>(submission, HttpStatus.OK);

    }

    @GetMapping("/getAllSubmissions")
    public ResponseEntity<List<Submission>> getAllSubmissions(

            @RequestHeader("Authorization") String jwt
    )throws Exception{
        List<Submission> submissions = submissionService.getAllTaskSubmissions();
        return new ResponseEntity<>(submissions, HttpStatus.OK);

    }

    @GetMapping("/getAllSubmissionsForTaskId/{taskId}")
    public ResponseEntity<List<Submission>> getAllSubmissionsForOneTaskId(
            @PathVariable Long taskId,
            @RequestHeader("Authorization") String jwt
    )throws Exception{
        List<Submission> submissions = submissionService.getTaskSubmissionByTaskId(taskId);
        return new ResponseEntity<>(submissions, HttpStatus.OK);

    }

    @PutMapping("/acceptOrDecline/{submissionId}")
    public ResponseEntity<Submission> acceptOrDecline(
            @PathVariable Long submissionId,
            @RequestParam("status") String status,
            @RequestHeader("Authorization") String jwt
    )throws Exception{
        Submission submission = submissionService.acceptOrDeclineSubmission(submissionId, status);
        return new ResponseEntity<>(submission, HttpStatus.OK);

    }
}
