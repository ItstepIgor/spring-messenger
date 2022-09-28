package com.springmessenger.controller;

import com.springmessenger.dto.UsersDto;
import com.springmessenger.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UsersService usersService;


    @GetMapping
    public List<UsersDto> findAll() {
        return usersService.findAll();
    }
}
