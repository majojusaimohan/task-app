package com.ashford.task.domain.dto;

import com.ashford.task.domain.entity.TaskPriority;
import com.ashford.task.domain.entity.TaskStatus;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record UpdateTaskRequestDto(
        @NotBlank(message = ERROR_MESSAGE_TITTLE_LENGTH)
        @Length(max=255, message = ERROR_MESSAGE_TITTLE_LENGTH)
        String title,
        @Length(max=1000, message = ERROR_MESSAGE_DESCRIPTION_LENGTH)
        @Nullable
        String description,
        @Nullable
        @FutureOrPresent(message = ERROR_MESSAGE_DUE_DATE_FUTURE )
        LocalDate dueDate,
        @NotNull(message = ERROR_MESSAGE_PRIORITY)
        TaskPriority priority,
        @NotNull(message = ERROR_MESSAGE_STATUS)
        TaskStatus status

) {

    private static final String  ERROR_MESSAGE_TITTLE_LENGTH=
            "Title must be between 1 and 255 characters";
    private static  final String  ERROR_MESSAGE_DESCRIPTION_LENGTH=
            "Description must be less than 1000 characters";
    private static final String ERROR_MESSAGE_DUE_DATE_FUTURE=
            "Due date must be in the present or future";
    private static final String ERROR_MESSAGE_PRIORITY=
            "Priority must not be null";
    private static final String ERROR_MESSAGE_STATUS=
            " Task Status must be provided";
}
