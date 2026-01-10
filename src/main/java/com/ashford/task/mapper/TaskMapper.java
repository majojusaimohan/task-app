package com.ashford.task.mapper;

import com.ashford.task.domain.CreateTaskRequest;
import com.ashford.task.domain.UpdateTaskRequest;
import com.ashford.task.domain.dto.CreateTaskRequestDto;
import com.ashford.task.domain.dto.TaskDto;
import com.ashford.task.domain.dto.UpdateTaskRequestDto;
import com.ashford.task.domain.entity.Task;

public interface TaskMapper {

    CreateTaskRequest fromDto(CreateTaskRequestDto createTaskRequestDto);

    TaskDto toDto(Task task);

    UpdateTaskRequest fromDto(UpdateTaskRequestDto updateTaskRequestDto);


}
