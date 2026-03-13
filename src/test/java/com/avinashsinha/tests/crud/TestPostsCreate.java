package com.avinashsinha.tests.crud;

import com.avinashsinha.asserts.AssertActions;
import com.avinashsinha.base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.util.Map;

public class TestPostsCreate extends BaseTest {

    private static final Logger logger = LogManager.getLogger(TestPostsCreate.class);

    @Test(groups = "Regression", priority = 1)
    @Owner("Avinash Sinha")
    @Description("TC#1 : Step 1. Create the Post")
    public void testCreatePost_POST() {

        logger.info("Build Payload and Send the API Request");

        // 1) build payload (can be dynamic or default)
        Map<String, Object> payload = payloadManager.createPostRequest();

        // 2) send request
        response = RestAssured.given(requestSpecification)
                .body(payload)
                .when().log().all()
                .post();

        // 3) basic status code validation
        validatableResponse = response.then().log().all().statusCode(201);

        // 4) use AssertActions for simple checks
        assertActions = new AssertActions(response);

        System.out.println("\n------------------------------ VERIFY AND PRINT ------------------------------\n");

        String title = response.jsonPath().getString("title");
        System.out.println("Title   : " + title);
        assertActions.verifyTitleNotEmpty();

        String body = response.jsonPath().getString("body");
        System.out.println("Body    : " + body);
        assertActions.verifyBodyNotBlank();

        int userId = response.jsonPath().getInt("userId");
        System.out.println("User Id : " + userId);
        assertActions.verifyUserIdNotNull();

        int id = response.jsonPath().getInt("id");
        System.out.println("Id      : " + id);
        assertActions.verifyIdNotNull();

        System.out.println();

        logger.info("End the API Request and assertions");

    }

}