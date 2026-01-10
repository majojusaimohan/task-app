package com.ashford.task.service;

import com.ashford.task.domain.CreateTaskRequest;
import com.ashford.task.domain.UpdateTaskRequest;
import com.ashford.task.domain.entity.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    Task createTask(CreateTaskRequest request);

    List<Task> listTasks();

    Task updateTask(UUID taskId, UpdateTaskRequest request);

    void deleteTask(UUID taskId);
}
