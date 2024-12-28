package api.stepDefinitions;

import api.models.response.LoginResponse;
import api.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

public class LoginApiStep {

    private LoginPage loginPage;
    private Response response;
    private LoginResponse loginResponse;

    @Given("the base URI is {string}")
    public void setBaseUri(String baseUri) {
        loginPage = new LoginPage();
        loginPage.setBaseUri(baseUri);
    }

    @When("the user sends a login request with username {string} and password {string}")
    public void sendLoginRequest(String username, String password) {
        response = loginPage.sendLoginRequest(username, password);
        loginResponse = loginPage.getLoginResponse(response);
    }

    @Then("the status code should be {int}")
    public void verifyResponseStatusCode(Integer expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
    }

    @Then("the response should contain a valid token")
    public void verifyResponseToken() {
        Assert.assertNotNull(loginResponse.getToken(), "Token is null!");
        Assert.assertFalse(loginResponse.getToken().isEmpty(), "Token is empty!");
    }

    @Then("the response should have the correct username {string}")
    public void verifyResponseUsername(String expectedUsername) {
        Assert.assertEquals(loginResponse.getUsername(), expectedUsername, "Username does not match!");
    }


}
