package com.springmessenger.integration.service;


import com.springmessenger.ApplicationRunner;
import com.springmessenger.dto.CreateUsersDto;
import com.springmessenger.dto.UsersDto;
import com.springmessenger.service.UsersService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;


@ActiveProfiles("test")
@Sql({
        "classpath:sql/data.sql"
})
@SpringBootTest(classes = ApplicationRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UsersServiceIT {


    @Autowired
    private UsersService usersService;


    @Test
    @Order(1)
    public void findAll() {
        List<UsersDto> users = usersService.findAll();
        Assertions.assertEquals(6, users.size());
    }

    //todo как обнулить результаты первого теста как сделать @SQL для срабатывания один раз (в дебаге показать)
    @Test
    @Order(2)
    public void create() {
        CreateUsersDto createUsersDto = new CreateUsersDto("Alex", "111", "6349220d872b4129567ae171");
        UsersDto expectedResult = new UsersDto(13, createUsersDto.getName(), createUsersDto.getPassword(), "6349220d872b4129567ae171");
        UsersDto actualResult = usersService.save(createUsersDto);
        Assertions.assertEquals(expectedResult, actualResult);
        List<UsersDto> users2 = usersService.findAll();
        Assertions.assertEquals(13, users2.size());
    }
}
