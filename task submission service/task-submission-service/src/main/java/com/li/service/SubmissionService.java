package com.li.service;

import com.li.model.Submission;

import java.util.List;

/**
 * @author: li he
 **/
public interface SubmissionService {

    Submission submitTask(Long taskId, String githubLink, Long userId, String jwt)throws Exception;

    Submission getTaskSubmissionById(Long submissionId) throws Exception;

    List<Submission> getAllTaskSubmissions();

    List<Submission> getTaskSubmissionByTaskId(Long taskId);

    Submission acceptOrDeclineSubmission(Long id, String status) throws  Exception;

}
