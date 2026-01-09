package com.ashford.task.service;

import com.ashford.task.domain.CreateTaskRequest;
import com.ashford.task.domain.entity.Task;

public interface TaskService {

    Task createTask(CreateTaskRequest request);
}
