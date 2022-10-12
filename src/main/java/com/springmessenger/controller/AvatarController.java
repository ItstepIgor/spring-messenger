package com.springmessenger.controller;


import com.springmessenger.entity.Avatar;
import com.springmessenger.service.AvatarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/avatars")
public class AvatarController {


    private final AvatarService avatarService;

    @PostMapping("/add")
    public String addAvatar(@RequestParam("image") MultipartFile image) throws IOException {
        return avatarService.addAvatar(image);
    }

    @GetMapping("/{id}")
    public String getAvatar(@PathVariable String id) {
        Avatar avatar = avatarService.getAvatar(id);
        return Base64.getEncoder().encodeToString(avatar.getImage().getData());
    }
}
