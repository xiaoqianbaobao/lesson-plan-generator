package com.example.lessonplan.util;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DocxGenerator {
    public static String generateDocx(String title, String content, String uploadDir) {
        try (XWPFDocument document = new XWPFDocument()) {
            // 添加标题
            XWPFParagraph titlePara = document.createParagraph();
            XWPFRun titleRun = titlePara.createRun();
            titleRun.setText(title);
            titleRun.setBold(true);
            titleRun.setFontSize(16);

            // 添加内容
            XWPFParagraph contentPara = document.createParagraph();
            XWPFRun contentRun = contentPara.createRun();
            contentRun.setText(content);

            // 保存文件
            String fileName = "lesson_plan_" + System.currentTimeMillis() + ".docx";
            String filePath = uploadDir + File.separator + fileName;
            File file = new File(filePath);
            file.getParentFile().mkdirs();
            try (FileOutputStream out = new FileOutputStream(file)) {
                document.write(out);
            }
            return filePath;
        } catch (IOException e) {
            throw new RuntimeException("生成DOCX文件失败", e);
        }
    }
}