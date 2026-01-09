package com.ashford.task.service.impl;

import com.ashford.task.domain.CreateTaskRequest;
import com.ashford.task.domain.entity.Task;
import com.ashford.task.domain.entity.TaskStatus;
import com.ashford.task.repository.TaskRepository;
import com.ashford.task.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TaskSwerviceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public  TaskSwerviceImpl(TaskRepository taskRepository){
        this.taskRepository=taskRepository;
    }

    @Override
    public Task createTask(CreateTaskRequest request) {
        Instant now=Instant.now();

        Task task = new Task(
                null,
                request.title(),
                request.description(),
                request.dueDate(),
                TaskStatus.OPEN,
                request.priority(),
                now,
                now
        );
    }

}
