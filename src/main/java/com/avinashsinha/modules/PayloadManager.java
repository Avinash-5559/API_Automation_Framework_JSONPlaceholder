package com.avinashsinha.modules;

import java.util.LinkedHashMap;
import java.util.Map;

public class PayloadManager {

    public Map<String, Object> createPostRequest() {

        Map<String, Object> createRequest = new LinkedHashMap<>();

        createRequest.put("title", "Create the Posts");
        createRequest.put("body", "The resource will not be really updated on the server but it will be faked as if.");
        createRequest.put("userId", 50);

        return createRequest;

    }

    public Map<String, Object> fullUpdatePostRequest() {

        Map<String, Object> fullUpdateRequest = new LinkedHashMap<>();

        fullUpdateRequest.put("id", 51);
        fullUpdateRequest.put("title", "Full Update the Posts");
        fullUpdateRequest.put("body", "Same like other APIs, the resource will not be really updated on the server but it will be just faked it.");
        fullUpdateRequest.put("userId", 50);

        return fullUpdateRequest;

    }

    public Map<String, Object> partialUpdatePostRequest() {

        Map<String, Object> partialUpdateRequest = new LinkedHashMap<>();

        partialUpdateRequest.put("title", "Partial Update the Posts");

        return partialUpdateRequest;

    }

}