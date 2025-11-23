package com.avinashsinha.asserts;

import io.restassured.response.Response;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertActions {

    private final Response response;

    public AssertActions(Response response) {
        this.response = response;
    }

    public void verifyUserIdNotNull() {
        Integer userId = response.jsonPath().getInt("userId");
        assertThat(userId).isNotNull();
    }

    public void verifyIdNotNull() {
        Integer id = response.jsonPath().getInt("id");
        assertThat(id).isNotNull();
    }

    public void verifyTitleNotEmpty() {
        String title = response.jsonPath().getString("title");
        assertThat(title).isNotEmpty();
    }

    public void verifyBodyNotBlank() {
        String body = response.jsonPath().getString("body");
        assertThat(body).isNotBlank();
    }

}