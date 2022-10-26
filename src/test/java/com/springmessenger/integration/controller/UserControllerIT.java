package com.springmessenger.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springmessenger.ApplicationRunner;
import com.springmessenger.dto.CreateUsersDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationRunner.class)
@AutoConfigureMockMvc
public class UserControllerIT {


    @Autowired
    private MockMvc mvc;

    @Test
    public void create() throws Exception {
        CreateUsersDto createUsersDto = new CreateUsersDto("Miron", "123", "6349220d872b4129567ae171", "ADMIN");

        mvc.perform(post("/api/users/registration")
                        .content(new ObjectMapper().writeValueAsString(createUsersDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }
}
