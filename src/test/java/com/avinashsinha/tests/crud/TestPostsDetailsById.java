package com.avinashsinha.tests.crud;

import com.avinashsinha.asserts.AssertActions;
import com.avinashsinha.base.BaseTest;
import com.avinashsinha.endpoints.APIConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class TestPostsDetailsById extends BaseTest {

    private static final Logger logger = LogManager.getLogger(TestPostsDetailsById.class);

    @Test(groups = "Regression", priority = 1)
    @Owner("Avinash Sinha")
    @Description("TC#1 : Step 1. Details of Post by Id")
    public void testDetailPostById_GET() {

        int id_e = 50;

        logger.info("Send the API Request");

        // 1) send request
        response = RestAssured.given(requestSpecification)
                .pathParam("id", id_e)
                .when().log().all()
                .get(APIConstants.USERS_ENDPOINTS);

        // 2) basic status code validation
        validatableResponse = response.then().log().all().statusCode(200);

        // 3) use AssertActions for simple checks
        assertActions = new AssertActions(response);

        System.out.println("\n------------------------------ VERIFY AND PRINT ------------------------------\n");

        Integer userId = response.jsonPath().getInt("userId");
        System.out.println("User Id : " + userId);
        assertActions.verifyUserIdNotNull();

        Integer id = response.jsonPath().getInt("id");
        System.out.println("Id      : " + id);
        assertActions.verifyIdNotNull();

        String title = response.jsonPath().getString("title");
        System.out.println("Title   : " + title);
        assertActions.verifyTitleNotEmpty();

        System.out.println();

        logger.info("End the API Request and assertions");

    }
}