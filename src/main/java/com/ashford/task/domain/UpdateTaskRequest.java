package com.ashford.task.domain;

import com.ashford.task.domain.entity.TaskPriority;
import com.ashford.task.domain.entity.TaskStatus;

import java.time.LocalDate;

public record UpdateTaskRequest(

        String title,
        String description,
        LocalDate dueDate,
        TaskStatus status,
        TaskPriority priority
) {
}
