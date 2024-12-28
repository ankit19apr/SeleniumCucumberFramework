package api.pages;

import api.base.AuthService;
import api.models.requests.LoginRequest;
import api.models.response.LoginResponse;
import io.restassured.response.Response;

public class LoginPage {

    private final AuthService authService;

    public LoginPage() {
        // Initialize the AuthService
        this.authService = new AuthService();
    }

    /**
     * Sets the base URI for the API.
     *
     * @param baseUri The base URI for the API.
     */
    public void setBaseUri(String baseUri) {
        authService.setBaseUri(baseUri);
    }

    /**
     * Sends a login request to the API.
     *
     * @param username The username for the login.
     * @param password The password for the login.
     * @return The Response object containing the API response.
     */
    public Response sendLoginRequest(String username, String password) {
        LoginRequest loginRequest = new LoginRequest(username, password);
        return authService.login(loginRequest);
    }

    /**
     * Extracts and returns the deserialized LoginResponse from the API response.
     *
     * @param response The Response object containing the API response.
     * @return The deserialized LoginResponse.
     */
    public LoginResponse getLoginResponse(Response response) {
        return response.as(LoginResponse.class);
    }
}
