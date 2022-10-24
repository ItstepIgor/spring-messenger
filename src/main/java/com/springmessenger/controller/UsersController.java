package com.springmessenger.controller;

import com.springmessenger.dto.CreateUsersDto;
import com.springmessenger.dto.UsersDto;
import com.springmessenger.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public UsersDto findById(@PathVariable("id") long id) {
        return usersService.findById(id);
    }

    @PostMapping("/registration")
    public ResponseEntity<UsersDto> create(@RequestBody CreateUsersDto createUsersDto) {
        return new ResponseEntity<>(usersService.save(createUsersDto), HttpStatus.CREATED);
    }

    @PutMapping
    public UsersDto update(@RequestBody UsersDto usersDto) {
        return usersService.update(usersDto);
    }


    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable("id") long id) {
        usersService.delete(id);
    }
}
