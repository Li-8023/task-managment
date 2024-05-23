package com.li.controller;

import com.li.model.Task;
import com.li.model.TaskStatus;
import com.li.model.UserDto;
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
public class HomeController {

    @Resource
    UserService userService;

    @Resource
    TaskService taskService;

    @GetMapping("/tasks")
    public ResponseEntity<String> home(){
        return new ResponseEntity<>("welcome to task service", HttpStatus.OK);
    }

}
