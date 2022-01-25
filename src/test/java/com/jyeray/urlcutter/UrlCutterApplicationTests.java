package com.jyeray.urlcutter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UrlCutterApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void create_a_shortcut_url() {
        var url = "https://joaquinmartin.dev";

        var response = restTemplate.postForEntity("/shortcut", url, CreateShortcutResponse.class);

        assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
        assertThat(response.getBody().urlPath, not(emptyString()));
    }

    @Test
    void redirect_to_final_url() {
        var url = "https://joaquinmartin.dev";
        var createdShortcutResponse = restTemplate.postForObject("/shortcut", url, CreateShortcutResponse.class);

        given()
            .baseUri(restTemplate.getRootUri())
            .redirects()
            .follow(false)
            .when()
            .get(createdShortcutResponse.urlPath)
            .then()
            .statusCode(HttpStatus.MOVED_PERMANENTLY.value())
            .header("location", is(url));
    }

    private record CreateShortcutResponse (String urlPath) { }
}
