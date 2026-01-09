package com.ashford.task.domain.entity;

import jakarta.persistence.*;
import org.springframework.data.convert.Jsr310Converters;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tasks")
public class Task {

    public Task() {
    }

    public Task(UUID id, String title, String description, LocalDate dueDate, TaskStatus status, TaskPriority priority, Instant created, Instant updated) {
        this.id = id;
        Title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.priority = priority;
        Created = created;
        this.updated = updated;
    }

    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    @Id
    private UUID id;

    @Column(name="title", nullable = false)
    private String Title;

    @Column(name="description", length = 1000)
    private String description;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    @Column(name="status", nullable = false)
    private TaskStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name="priority", nullable = false)
    private TaskPriority priority;

    @Column(name="created", nullable = false, updatable = false)
    private Instant Created;

    @Column(name="updated", nullable = false)
    private Instant updated;




    public Instant getUpdated() {
        return updated;
    }

    public void setUpdated(Instant updated) {
        this.updated = updated;
    }

    public Instant getCreated() {
        return Created;
    }

    public void setCreated(Instant created) {
        Created = created;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return Title;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", Title='" + Title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", status=" + status +
                ", priority=" + priority +
                ", Created=" + Created +
                ", updated=" + updated +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public void setTitle(String title) {
        Title = title;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


}
