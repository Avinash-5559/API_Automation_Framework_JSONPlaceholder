package com.avinashsinha.tests.integration;

import com.avinashsinha.asserts.AssertActions;
import com.avinashsinha.base.BaseTest;
import com.avinashsinha.endpoints.APIConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class TestE2EFlow extends BaseTest {

    private static final Logger logger = LogManager.getLogger(TestE2EFlow.class);

    @Test(groups = "QA", priority = 1)
    @Owner("Avinash Sinha")
    @Description("TC#1 : Step 1. Create the Post")
    public void testCreatePost_POST() {

        logger.info("Start the Post Creation");

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

        Integer userId = response.jsonPath().getInt("userId");
        System.out.println("User Id : " + userId);
        assertActions.verifyUserIdNotNull();

        Integer id = response.jsonPath().getInt("id");
        System.out.println("Id      : " + id);
        assertActions.verifyIdNotNull();

        System.out.println();

        logger.info("Complete the Post Creation");

    }


    @Test(groups = "QA", priority = 2)
    @Owner("Avinash Sinha")
    @Description("TC#2 : Step 2. Detail of Posts")
    public void testDetailPosts_GET() {

        logger.info("Show the Details of All Posts");

        // 1) send request
        response = RestAssured.given(requestSpecification)
                .when().log().all()
                .get();

        // 2) basic status code validation
        validatableResponse = response.then().log().all().statusCode(200);

        System.out.println();

        logger.info("End the Details of All Posts");

    }

    @Test(groups = "QA", priority = 3)
    @Owner("Avinash Sinha")
    @Description("TC#3 : Step 3. Details of Post by Id")
    public void testDetailPostById_GET(ITestContext iTestContext) {

        int id_e = 81;

        logger.info("Show the Details of Single Post by Id");

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

        iTestContext.setAttribute("id", id);

        logger.info("End the Details of Single Post");

    }

    @Test(groups = "QA", priority = 4)
    @Owner("Avinash Sinha")
    @Description("TC#4 : Step 4. Full Update the Post by Id")
    public void testUpdatePostId_PUT(ITestContext iTestContext) {

        int id_e = (int) iTestContext.getAttribute("id");

        logger.info("Full Update the Post by Id");

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

        logger.info("Complete the Full Updation");

    }

    @Test(groups = "QA", priority = 5)
    @Owner("Avinash Sinha")
    @Description("TC#5 : Step 5. Partial Update the Post by Id")
    public void testPartialPostId_PATCH(ITestContext iTestContext) {

        int id_e = (int) iTestContext.getAttribute("id");

        logger.info("Partial Update the Post by Id");

        // 1) build payload (can be dynamic or default)
        Map<String, Object> payload = payloadManager.partialUpdatePostRequest();

        // 2) send request
        response = RestAssured.given(requestSpecification)
                .pathParam("id", id_e)
                .body(payload)
                .when().log().all()
                .patch(APIConstants.USERS_ENDPOINTS);

        // 3) basic status code validation
        validatableResponse = response.then().log().all().statusCode(200);

        // 4) use Assertions for simple checks
        System.out.println("\n------------------------------ VERIFY AND PRINT ------------------------------\n");

        Integer userId = response.jsonPath().getInt("userId");
        System.out.println("User Id : " + userId);
        assertThat(userId).isNotNull().isNotZero().isNotNegative();

        Integer id = response.jsonPath().getInt("id");
        System.out.println("Id      : " + id);
        assertThat(id).isNotNull().isNotZero().isNotNegative();

        String title = response.jsonPath().getString("title");
        System.out.println("Title   : " + title);
        assertThat(title).isNotNull().isNotBlank().isNotEmpty();

        System.out.println();

        logger.info("Complete the Partial Updation");

    }

    @Test(groups = "QA", priority = 6)
    @Owner("Avinash Sinha")
    @Description("TC#6 : Step 6. Delete the Post by Id")
    public void testDeletePostId_DELETE(ITestContext iTestContext) {

        int id_e = (int) iTestContext.getAttribute("id");

        logger.info("Delete the Post by Id");

        // 1) send request
        response = RestAssured.given(requestSpecification)
                .pathParam("id", id_e)
                .when().log().all()
                .delete(APIConstants.USERS_ENDPOINTS);

        // 2) basic status code validation
        validatableResponse = response.then().log().all().statusCode(200);

        System.out.println();

        logger.info("Deletion is Done");

    }

}