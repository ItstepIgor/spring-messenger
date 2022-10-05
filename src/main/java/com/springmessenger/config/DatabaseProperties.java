package com.springmessenger.config;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DatabaseProperties {

    private String url;
    private String username;
    private String password;
    private String driverClassName;
}
