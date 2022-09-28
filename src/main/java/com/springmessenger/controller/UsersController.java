package com.springmessenger.controller;

import com.springmessenger.dto.CreateUsersDto;
import com.springmessenger.dto.UsersDto;
import com.springmessenger.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public UsersDto findById(@PathVariable("id") long id) {
        return usersService.findById(id);
    }

    @PostMapping
    public UsersDto create(@RequestBody CreateUsersDto createUsersDto) {
        return usersService.save(createUsersDto);
    }

    @PutMapping
    public UsersDto update(@RequestBody UsersDto usersDto) {
        return usersService.update(usersDto);
    }
}
