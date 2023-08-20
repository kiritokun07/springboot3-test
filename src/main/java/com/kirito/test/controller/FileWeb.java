package com.kirito.test.controller;

import com.kirito.test.service.FileService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileUrlResource;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RestController
@Slf4j
public class FileWeb {
    @Resource
    private FileService fileService;

    /**
     * 文件上传
     */
    @PostMapping("/file/upload")
    public String upload(HttpServletRequest request,
                         @RequestParam("file") MultipartFile[] fileList) throws Exception {
        String uploadUser = request.getParameter("uploadUser");
        if (uploadUser.isEmpty()) {
            return "upload-user is empty";
        }
        log.info("upload-user:{}", uploadUser);
        for (MultipartFile multipartFile : fileList) {
            // 解析文件信息和保存
            fileService.dealFile(multipartFile);
        }
        return "success";
    }

    /**
     * 文件下载
     */
    @GetMapping("/file/download")
    public void download(@RequestParam("fileName") String fileName,
                         HttpServletResponse response) throws Exception {
        if (!fileName.isBlank()) {
            String filePath = ResourceUtils.getURL("m1-04-boot-file/src/main/resources/file").getPath();
            File file = new File(filePath, fileName);
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
            response.setContentType("application/octet-stream");

            FileUrlResource classPathResource = new FileUrlResource(filePath);
            long length = classPathResource.getFile().length();
            try (OutputStream outputStream = response.getOutputStream()) {
                byte[] buff = new byte[1024];
                BufferedInputStream bis = null;
                InputStream inputStream = classPathResource.getInputStream();
                bis = new BufferedInputStream(inputStream);
                int i = bis.read(buff);
                while (i != -1) {
                    outputStream.write(buff, 0, buff.length);
                    outputStream.flush();
                    i = bis.read(buff);
                }
                bis.close();
            }

            //Files.copy(Paths.get(file.getPath()), response.getOutputStream());
        }
    }
}
