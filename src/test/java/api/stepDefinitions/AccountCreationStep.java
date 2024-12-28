package api.stepDefinitions;

import api.models.requests.SignupRequest;
import api.pages.AccountCreationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

public class AccountCreationStep {

    private SignupRequest signupRequest;
    private Response response;
    private AccountCreationPage accountCreationPage;

    @Given("the user provides valid account creation details")
    public void theUserProvidesValidAccountCreationDetails() {
        signupRequest = new SignupRequest.Builder()
                .userName("dikeje123")
                .email("dikeje5082@gholar.com")
                .password("viraaj123")
                .firstName("Aks")
                .lastName("Sharma")
                .mobileNumber("9876542110")
                .build();
    }

    @When("the user sends a request to create an account")
    public void theUserSendsARequestToCreateAnAccount() {
        String baseUri = "http://64.227.160.186:8080"; // Base URI for the environment
        accountCreationPage = new AccountCreationPage(baseUri); // Instantiate AccountCreationPage
        response = accountCreationPage.createAccount(signupRequest); // Call the createAccount method
    }

    @Then("the API should return a success message {string}")
    public void theAPIShouldReturnASuccessMessage(String expectedMessage) {
        Assert.assertEquals(response.asPrettyString(), expectedMessage, "User registered successfully!");
    }


}
