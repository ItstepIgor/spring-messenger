package com.springmessenger.controller;

import com.springmessenger.service.AvatarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/avatars")
public class AvatarController {

    private final AvatarService avatarService;


    @PostMapping("/add")
    public String addAvatar(@RequestParam("file") MultipartFile file) throws IOException {
        return avatarService.addAvatar(file.getOriginalFilename(), file);
    }


    @GetMapping("/{id}")
    public ResponseEntity<GridFsResource> getAvatar(@PathVariable String id) throws Exception {

        GridFsResource gridFsResource = avatarService.getAvatar(id);
        //Преобразование русских имен файлов
        ContentDisposition contentDisposition = ContentDisposition.builder("attachment")
                .filename(gridFsResource.getFilename(), StandardCharsets.UTF_8)
                .build();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentDisposition(contentDisposition);
        httpHeaders.setContentType(MediaType.IMAGE_JPEG);

        return ResponseEntity.ok()
                .headers(httpHeaders)
                .body(gridFsResource);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        avatarService.delete(id);
    }
}