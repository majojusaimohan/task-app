package com.ashford.task.Controller;


import com.ashford.task.domain.CreateTaskRequest;
import com.ashford.task.domain.UpdateTaskRequest;
import com.ashford.task.domain.dto.CreateTaskRequestDto;
import com.ashford.task.domain.dto.TaskDto;
import com.ashford.task.domain.dto.UpdateTaskRequestDto;
import com.ashford.task.domain.entity.Task;
import com.ashford.task.mapper.TaskMapper;
import com.ashford.task.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @PostMapping
    public ResponseEntity<TaskDto> createTask(
            @RequestBody @Valid CreateTaskRequestDto createTaskRequestDto)
    {
        CreateTaskRequest CreateTaskRequest=taskMapper.fromDto(createTaskRequestDto);
        Task task=taskService.createTask(CreateTaskRequest);
       TaskDto createdTaskDto= taskMapper.toDto(task);
       return new ResponseEntity<>(createdTaskDto, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> listTasks(){
        List<Task> tasks= taskService.listTasks();
        List<TaskDto> taskdDtos= tasks.stream().map(taskMapper::toDto).toList();
        return ResponseEntity.ok(taskdDtos);

    }

    @PutMapping(path = "/{taskId}")
    public  ResponseEntity<TaskDto> updateTask
            (@PathVariable UUID taskId,
             @RequestBody @Valid UpdateTaskRequestDto updateTaskRequestDto){

         UpdateTaskRequest request= taskMapper.fromDto(updateTaskRequestDto);
         Task task= taskService.updateTask(taskId,request);
        TaskDto taskDto= taskMapper.toDto(task);
        return ResponseEntity.ok(taskDto);

    }

    @DeleteMapping(path = "/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable UUID taskId) {
        taskService.deleteTask(taskId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
