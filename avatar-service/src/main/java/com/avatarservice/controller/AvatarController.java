package com.avatarservice.controller;

import com.avatarservice.entity.Avatar;
import com.avatarservice.service.AvatarService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/avatars")
public class AvatarController {

    private final AvatarService avatarService;


    @PostMapping
    public String addAvatar(@RequestParam("file") MultipartFile file) {
        return avatarService.addAvatar(file.getOriginalFilename(), file);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InputStreamResource> getAvatar(@PathVariable Long id) {
        Avatar avatar = avatarService.getAvatar(id);
        //Преобразование русских имен файлов
        ContentDisposition contentDisposition =
                ContentDisposition
                        .attachment()
                        .filename(avatar.getTitle(), StandardCharsets.UTF_8)
                        .build();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentDisposition(contentDisposition);
        httpHeaders.setContentType(MediaType.valueOf(avatar.getContentType()));

        return ResponseEntity
                .ok()
                .headers(httpHeaders)
                .body(new InputStreamResource(avatar.getImage()));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        avatarService.delete(id);
    }
}
