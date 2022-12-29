package com.gatewayservice.feign;

import com.gatewayservice.entity.Users;
import com.gatewayservice.entity.jwt.AuthRequest;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.Instant;

@Component
public class UserWebClients {


    private static final String baseUrlUser = "http://localhost:8765/api/users/";

    @SneakyThrows
    public void userExists(AuthRequest authRequest) {

//        Flux<Users> fluxUser = WebClient.create(baseUrlUser)
//                .post()
//                .uri("login")
//                .bodyValue(authRequest)
//                .retrieve()
//                .bodyToFlux(Users.class);
//
//        fluxUser.subscribe(users -> System.out.println(users + " " + Instant.now()));
//        System.out.println(Instant.now());

        Users user = WebClient.create(baseUrlUser)
                .post()
                .uri("login")
                .bodyValue(authRequest)
                .retrieve()
                .toEntity(Users.class)
                .toFuture()
                .get()
                .getBody();

        System.out.println(user);



//        try {

//            Users user = WebClient.create(baseUrlUser)
//                    .post()
//                    .uri("login")
//                    .bodyValue(authRequest)
//                    .retrieve()
//                    .bodyToFlux(Users.class)
//                    .blockFirst(); // блокирует поток до получения 1й записи
//        System.out.println(user);


//            if (user != null) {
//                return user;
            }

//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return false;
//
//    }

}
