package com.avinashsinha.tests.crud;

import com.avinashsinha.base.BaseTest;
import com.avinashsinha.endpoints.APIConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

public class TestPostsFullUpdate extends BaseTest {

    private static final Logger logger = LogManager.getLogger(TestPostsFullUpdate.class);

    @Test(groups = "Regression", priority = 1)
    @Owner("Avinash Sinha")
    @Description("TC#1 : Step 1. Full Update the Post by Id")
    public void testUpdatePostId_PUT() {

        int id_e = 51;

        logger.info("Build Payload and Send the API Request");

        // 1) build payload (can be dynamic or default)
        Map<String, Object> payload = payloadManager.fullUpdatePostRequest();

        // 2) send request
        response = RestAssured.given(requestSpecification)
                .pathParam("id", id_e)
                .body(payload)
                .when().log().all()
                .put(APIConstants.USERS_ENDPOINTS);

        // 3) basic status code validation
        validatableResponse = response.then().log().all().statusCode(200);

        // 4) use Assertions for simple checks
        System.out.println("\n------------------------------ VERIFY AND PRINT ------------------------------\n");

        Integer id = response.jsonPath().getInt("id");
        System.out.println("Id      : " + id);
        assertThat(id).isNotNull().isNotZero().isNotNegative();

        String title = response.jsonPath().getString("title");
        System.out.println("Title   : " + title);
        assertThat(title).isNotNull().isNotBlank().isNotEmpty();

        String body = response.jsonPath().getString("body");
        System.out.println("Body    : " + body);
        assertThat(body).isNotNull().isNotBlank().isNotEmpty();

        Integer userId = response.jsonPath().getInt("userId");
        System.out.println("User Id : " + userId);
        assertThat(userId).isNotNull().isNotZero().isNotNegative();

        System.out.println();

        logger.info("End the API Request and assertions");

    }
}
