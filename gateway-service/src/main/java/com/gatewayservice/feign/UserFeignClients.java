package com.gatewayservice.feign;

import com.gatewayservice.config.FeignConfiguration;
import com.gatewayservice.entity.jwt.AuthRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-service", configuration = FeignConfiguration.class)
public interface UserFeignClients {

    @PostMapping("/api/users/login")
    boolean findByUserLogin (@RequestBody AuthRequest authRequest);
}
