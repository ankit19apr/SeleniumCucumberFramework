package api.pages;

import api.base.AuthService;
import api.models.requests.SignupRequest;
import io.restassured.response.Response;

public class AccountCreationPage {

    private AuthService authService;

    public AccountCreationPage(String baseUri) {
        this.authService = new AuthService();
        this.authService.setBaseUri(baseUri); // Dynamically set the base URI
    }

    /**
     * Sends a request to create an account with the given details.
     *
     * @param signupRequest The SignupRequest object containing user details.
     * @return The Response object from the API.
     */
    public Response createAccount(SignupRequest signupRequest) {
        return authService.signUp(signupRequest);
    }
}
