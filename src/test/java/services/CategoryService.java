package services;

import io.restassured.response.Response;

import static Utilities.ApiUtils.*;

public class CategoryService {

    public Response getCategoryDetails(int categoryId) {
        return sendGetRequest("/Categories/" + categoryId + "/Details.json");
    }

    public Response getCategoryDetailsWithInvalidQuery(int categoryId) {
        return sendGetRequest("/Categories/" + categoryId + "/Details.json?invalidParam=true");
    }
}