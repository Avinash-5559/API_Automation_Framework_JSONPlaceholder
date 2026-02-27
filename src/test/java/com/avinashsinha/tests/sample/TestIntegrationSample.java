package com.avinashsinha.tests.sample;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestIntegrationSample {

    @Test(groups = "qa", priority = 1)
    @Owner("Avinash Sinha")
    @Description("TC#1 : Step 1. Create the Posts")
    public void testCreatePosts() {
        Assert.assertTrue(true);
    }

    @Test(groups = "qa", priority = 2)
    @Owner("Avinash Sinha")
    @Description("TC#2 : Step 2. Verify the Posts")
    public void testVerifyPosts() {
        Assert.assertTrue(true);
    }

    @Test(groups = "qa", priority = 3)
    @Owner("Avinash Sinha")
    @Description("TC#3 : Step 3 : Update the Posts")
    public void testUpdatePosts() {
        Assert.assertTrue(true);
    }

    @Test(groups = "qa", priority = 4)
    @Owner("Avinash Sinha")
    @Description("TC#4 : Step 4 : Delete the Posts")
    public void testDeletePosts() {
        Assert.assertTrue(true);
    }

}