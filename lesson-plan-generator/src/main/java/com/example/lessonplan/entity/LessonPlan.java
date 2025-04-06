package com.example.lessonplan.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "lesson_plans")
public class LessonPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(columnDefinition = "TEXT")
    private String content;
    private String filePath;
    private LocalDateTime createdAt;
}