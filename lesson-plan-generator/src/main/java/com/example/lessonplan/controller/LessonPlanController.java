package com.example.lessonplan.controller;

import com.example.lessonplan.service.LessonPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/lesson")
public class LessonPlanController {

    @Autowired
    private LessonPlanService lessonPlanService;

    @GetMapping
    public String index(Model model) {
        return "lesson";
    }

    @PostMapping("/generate")
    public String generateLessonPlan(@RequestParam String title, 
                                   @RequestParam String notes,
                                   RedirectAttributes redirectAttributes) {
        try {
            String filePath = lessonPlanService.generateLessonPlan(title, notes);
            redirectAttributes.addFlashAttribute("message", "教案生成成功！");
            redirectAttributes.addFlashAttribute("filePath", filePath);
            return "redirect:/files";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "生成教案时发生错误：" + e.getMessage());
            return "redirect:/lesson";
        }
    }

    @GetMapping("/files")
    public String listFiles(Model model) {
        File uploadDir = new File("uploads");
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        List<String> files = Arrays.stream(uploadDir.listFiles())
                .filter(file -> file.isFile() &&
                        (file.getName().endsWith(".docx") ||
                         file.getName().endsWith(".doc")))
                .map(File::getName)
                .collect(Collectors.toList());

        model.addAttribute("files", files);
        return "lesson";
    }

    @GetMapping("/preview/{filename}")
    public String previewFile(@PathVariable String filename, Model model) {
        model.addAttribute("filename", filename);
        return "preview";
    }

    @GetMapping("/download/{filename}")
    public String downloadFile(@PathVariable String filename) {
        return "redirect:/uploads/" + filename;
    }
}