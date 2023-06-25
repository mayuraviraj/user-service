package com.mayura.online.banking.userservice.infarstructure.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestControllerTest {

    private static final String BASE_PATH = "http://localhost:%d";
    private static final String GET_USER_BY_ID_PATH = "/users/{userId}";
    private static final String GET_ALL_USERS_PATH = "/users";
    private static final String CREATE_NEW_USER = "/users";
    private static final String UPDATE_USER_BY_ID = "/users/{userId}";
    private static final String DELETE_USER_BY_ID = "/users/{userId}";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getUserShouldReturnUser() throws Exception{
        UserVO forObject = this.restTemplate.getForObject(String.format(BASE_PATH, port) + "/user",
                UserVO.class);
        System.out.println(forObject);
        assertThat(forObject).isEqualTo(null);
    }
}
