package com.example.lessonplan.repository;

import com.example.lessonplan.entity.LessonPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LessonPlanRepository extends JpaRepository<LessonPlan, Long> {
    List<LessonPlan> findByUserId(Long userId);
}