package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.testng.Assert;
import services.CategoryService;
import java.util.List;
import java.util.Map;

public class CategoryDetailsSteps {
    private Response response;
    private CategoryService categoryService = new CategoryService();

    @Given("I send a GET request to the Category Details API")
    public void sendGetRequest() {
        response = categoryService.getCategoryDetails(6327);
    }

    @Given("I send a GET request to the Category Details API with invalid Category ID")
    public void sendGetRequestWithInvalidCategoryId() {
        response = categoryService.getCategoryDetails(9999);
    }

    @Given("I send a GET request to the Category Details API with invalid query parameter")
    public void sendGetRequestWithInvalidQueryParameter() {
        response = categoryService.getCategoryDetailsWithInvalidQuery(6327);
    }

    @Then("the response status code should be {int}")
    public void verifyStatusCode(int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "Status code mismatch");
    }
    @Then("the response status code should not be {int}")
    public void the_response_status_code_should_not_be(Integer statusCodeNegator) {
        Assert.assertNotEquals(response.getStatusCode(), statusCodeNegator, "Status code not equal to 200 Negative test sucess");
    }

    @Then("the response body should contain Name as {string}")
    public void verifyName(String expectedName) {
        String actualName = response.jsonPath().getString("Name");
        Assert.assertEquals(actualName, expectedName, "Name mismatch");
    }

    @Then("the response body should contain CanRelist as true")
    public void verifyCanRelist() {
        boolean canRelist = response.jsonPath().getBoolean("CanRelist");
        Assert.assertTrue(canRelist, "CanRelist is not true");
    }

    @Then("the Promotions element with Name {string} should have Description containing {string}")
    public void verifyPromotionDescription(String promotionName, String expectedDescription) {
        List<Map<String, Object>> promotions = response.jsonPath().getList("Promotions");
        boolean promotionFound = false;

        for (Map<String, Object> promotion : promotions) {
            if (promotion.get("Name").equals(promotionName)) {
                String description = (String) promotion.get("Description");
                Assert.assertTrue(description.contains(expectedDescription), "Description mismatch");
                promotionFound = true;
                break;
            }
        }

        Assert.assertTrue(promotionFound, "Promotion with Name '" + promotionName + "' not found");
    }

    @Then("the response body should contain an error message")
    public void verifyErrorMessage() {
        String errorMessage = response.jsonPath().getString("Message");
        Assert.assertNotNull(errorMessage, "Error message not found in the response");
    }
}
