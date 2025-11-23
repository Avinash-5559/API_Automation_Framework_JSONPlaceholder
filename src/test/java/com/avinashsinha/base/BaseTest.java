package com.avinashsinha.base;

import com.avinashsinha.asserts.AssertActions;
import com.avinashsinha.endpoints.APIConstants;
import com.avinashsinha.modules.PayloadManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public RequestSpecification requestSpecification;
    public Response response;
    public ValidatableResponse validatableResponse;
    public PayloadManager payloadManager;
    public AssertActions assertActions;

    @BeforeMethod
    public void setUp() {

        payloadManager = new PayloadManager();

        requestSpecification = RestAssured.given()
                .baseUri(APIConstants.BASE_URL)
                .basePath(APIConstants.BASE_PATH)
                .contentType(ContentType.JSON)
                .log().all();
    }

}