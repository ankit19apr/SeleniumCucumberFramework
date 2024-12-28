package api.stepDefinitions;
import api.pages.ForgotPasswordPage;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

public class ForgotPasswordStep {
    private String email;
    private Response response;
    private ForgotPasswordPage forgotPasswordPage;

    @Given("the user provides a valid email address {string}")
    public void theUserProvidesAValidEmailAddress(String email) {
        this.email = email;
    }

    @When("the user sends a request to reset the password")
    public void theUserSendsARequestToResetThePassword() {
        String baseUri = "http://64.227.160.186:8080"; // Base URI for the environment
        forgotPasswordPage = new ForgotPasswordPage(baseUri); // Instantiate ForgotPasswordPage
        response = forgotPasswordPage.resetPassword(email); // Call the resetPassword method
    }

    @Then("the API should return a success message for forgot password {string}")
    public void theAPIShouldReturnASuccessMessageForForgotPassword(String expectedMessage) {
        Assert.assertEquals(response.asPrettyString(), expectedMessage, "If your email exists in our system, you will receive reset instructions.");
    }
}
