package com.mayura.online.banking.userservice.infarstructure.web;

import com.mayura.online.banking.userservice.util.ApiUtil;
import org.apache.commons.text.StringSubstitutor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestControllerTest {

    private static final String BASE_PATH = "http://localhost:%d";
    private static final String GET_USER_BY_ID_PATH = "/users/${userId}";
    private static final String GET_ALL_USERS_PATH = "/users";
    private static final String CREATE_NEW_USER = "/users";
    private static final String UPDATE_USER_BY_ID = "/users/{userId}";
    private static final String DELETE_USER_BY_ID = "/users/{userId}";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getUserShouldReturnUser() throws Exception {
        String userId = createNewUser(ApiUtil.getUser());
        Map<String, String> substitutes = new HashMap<>();
        substitutes.put("userId", userId);
        StringSubstitutor stringSubstitutor = new StringSubstitutor(substitutes);
        UserVO forObject = this.restTemplate.getForObject(String.format(BASE_PATH, port)
                        + stringSubstitutor.replace(GET_USER_BY_ID_PATH),
                UserVO.class);
        assertThat(forObject).isNotNull();
        assertThat(forObject.id()).isEqualTo(userId);
    }

    private String createNewUser(UserVO user) throws URISyntaxException {
        URI uri = new URI(String.format(BASE_PATH, port) + CREATE_NEW_USER);
        UserVO userVO = UserVO.builder()
                .id("test-id-x")
                .firstName("test user")
                .lastName("last name")
                .email("test@email.com")
                .build();

        HttpEntity<UserVO> request = new HttpEntity<>(userVO);

        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
        System.out.println(result);
        return result.getBody();
    }
}
