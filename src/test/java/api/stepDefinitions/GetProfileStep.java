package api.stepDefinitions;

import api.pages.AuthPage;
import api.pages.UserProfilePage;
import api.models.requests.LoginRequest;
import api.models.response.LoginResponse;
import api.models.response.UserProfileResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

public class GetProfileStep {

    private String username;
    private String password;
    private String token;
    private Response response;
    private AuthPage authPage;
    private UserProfilePage userProfilePage;

    @Given("the user logs in with username {string} and password {string}")
    public void theUserLogsInWithUsernameAndPassword(String username, String password) {
        this.username = username;
        this.password = password;

        String baseUri = "http://64.227.160.186:8080"; // Base URI for the environment
        authPage = new AuthPage(baseUri);
        response = authPage.login(new LoginRequest(username, password));
        LoginResponse loginResponse = response.as(LoginResponse.class);
        token = loginResponse.getToken(); // Extract the token
    }

    @When("the user sends a request to fetch their profile")
    public void theUserSendsARequestToFetchTheirProfile() {
        userProfilePage = new UserProfilePage("http://64.227.160.186:8080"); // Base URI for profile
        response = userProfilePage.getUserProfile(token);
    }

    @Then("the API should return the username as {string}")
    public void theAPIShouldReturnTheUsernameAs(String expectedUsername) {
        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
        Assert.assertEquals(userProfileResponse.getUsername(), expectedUsername, "Username mismatch!");
    }


}
