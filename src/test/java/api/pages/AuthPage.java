package api.pages;

import api.base.AuthService;
import api.models.requests.LoginRequest;
import io.restassured.response.Response;

public class AuthPage {

    private AuthService authService;

    public AuthPage(String baseUri) {
        this.authService = new AuthService();
        this.authService.setBaseUri(baseUri); // Dynamically set the base URI
    }

    /**
     * Sends a login request to the API.
     *
     * @param loginRequest The LoginRequest object containing user credentials.
     * @return The Response object from the API.
     */
    public Response login(LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }
}
