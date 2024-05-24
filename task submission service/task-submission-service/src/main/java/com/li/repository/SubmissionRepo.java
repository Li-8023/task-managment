package com.li.repository;

import com.li.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: li he
 **/
public interface SubmissionRepo extends JpaRepository<Submission, Long> {

    List<Submission> findByTaskId(Long taskId);

}
