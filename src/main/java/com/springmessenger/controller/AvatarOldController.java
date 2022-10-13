package com.springmessenger.controller;


import com.springmessenger.entity.AvatarOld;
import com.springmessenger.service.AvatarOldService;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("/api/avatarsold")
public class AvatarOldController {


    private final AvatarOldService avatarOldService;

    @PostMapping("/add")
    public String addAvatarOld(@RequestParam("image") MultipartFile image) throws IOException {
        return avatarOldService.addAvatarOld(image.getOriginalFilename(), image);
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getAvatarOld(@PathVariable String id) {
        AvatarOld avatarOld = avatarOldService.getAvatarOld(id);

        //Преобразование русских имен файлов
        ContentDisposition contentDisposition = ContentDisposition.builder("attachment")
                .filename(avatarOld.getTitle(), StandardCharsets.UTF_8)
                .build();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentDisposition(contentDisposition);
        httpHeaders.setContentType(MediaType.IMAGE_JPEG);

        return ResponseEntity
                .ok()
                .headers(httpHeaders)
                .body(avatarOld.getImage().getData());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        avatarOldService.delete(id);
    }
}
