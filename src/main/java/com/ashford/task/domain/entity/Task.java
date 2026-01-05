package com.ashford.task.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tasks")
public class Task {

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



}
