package com.ashford.task.mapper.impl;

import com.ashford.task.domain.CreateTaskRequest;
import com.ashford.task.domain.UpdateTaskRequest;
import com.ashford.task.domain.dto.CreateTaskRequestDto;
import com.ashford.task.domain.dto.TaskDto;
import com.ashford.task.domain.dto.UpdateTaskRequestDto;
import com.ashford.task.domain.entity.Task;
import com.ashford.task.mapper.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {
    @Override
    public CreateTaskRequest fromDto(CreateTaskRequestDto createTaskRequestDto) {
        return new CreateTaskRequest(
                createTaskRequestDto.title()
                , createTaskRequestDto.description()
                , createTaskRequestDto.dueDate()
                , createTaskRequestDto.priority()

        );
    }

    @Override
    public TaskDto toDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getPriority(),
                task.getStatus()

        );
    }

    @Override
    public UpdateTaskRequest fromDto(UpdateTaskRequestDto dto) {
        return new UpdateTaskRequest(
                dto.title(),
                dto.description(),
                dto.dueDate(),
                dto.status(),
                dto.priority()
        );
    }
}
