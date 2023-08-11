package com.kirito.test.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * 文件服务类
 */
@Service
@Slf4j
public class FileService {

    public void dealFile(MultipartFile multipartFile) throws Exception {
        log.info("Name >> {}", multipartFile.getName());
        log.info("OriginalFilename >> {}", multipartFile.getOriginalFilename());
        log.info("ContentType >> {}", multipartFile.getContentType());
        log.info("Size >> {}", multipartFile.getSize());
        // 文件输出地址
        String filePath = ResourceUtils.getURL("m1-04-boot-file/src/main/resources/file").getPath();
        File writeFile = new File(filePath, multipartFile.getOriginalFilename());
        multipartFile.transferTo(writeFile);
    }
}