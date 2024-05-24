package com.li.service;

import com.li.model.Submission;
import com.li.repository.SubmissionRepo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: li he
 **/
@Service
public class SubmissionServiceImpl implements SubmissionService{

    @Resource
    SubmissionRepo submissionRepo;

    @Override
    public Submission submitTask(Long taskId, String githubLink, Long userId) throws Exception {

        return null;
    }

    @Override
    public Submission getTaskSubmissionById(Long submissionId) throws Exception {
        return null;
    }

    @Override
    public List<Submission> getAllTaskSubmissions() {
        return List.of();
    }

    @Override
    public List<Submission> getTaskSubmissionByTaskId(Long taskId) {
        return List.of();
    }

    @Override
    public Submission acceptOrDeclineSubmission(Long id, String status) throws Exception {
        return null;
    }
}
