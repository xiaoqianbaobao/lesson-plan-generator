package com.example.lessonplan.service;

import java.io.File;
import java.util.List;

public interface LessonPlanService {
    String generateLessonPlan(String title, String notes);
    String saveToWord(String content, String title);
    List<String> listGeneratedFiles();
    File getFile(String filename);
}