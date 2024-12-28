package api.base;

import api.models.requests.LoginRequest;
import api.models.requests.SignupRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;

public class AuthService extends BaseService {

    private String baseUri; // Added field for dynamic base URI
    private static final String BASE_PATH = "/api/auth/";

    /**
     * Sets the base URI dynamically for the AuthService.
     *
     * @param baseUri The base URI for the API.
     */
    public void setBaseUri(String baseUri) {
        this.baseUri = baseUri;
        RestAssured.baseURI = baseUri; // Configure RestAssured to use the provided base URI
    }

    /**
     * Sends a login request to the API.
     *
     * @param body The LoginRequest object containing username and password.
     * @return The Response object from the API.
     */
    public Response login(LoginRequest body) {
        validateBaseUri(); // Ensure base URI is set
        return postRequest(body, BASE_PATH + "login");
    }

    /**
     * Sends a sign-up request to the API.
     *
     * @param body The SignupRequest object containing user details.
     * @return The Response object from the API.
     */
    public Response signUp(SignupRequest body) {
        validateBaseUri(); // Ensure base URI is set
        return postRequest(body, BASE_PATH + "signup");
    }

    /**
     * Sends a forgot-password request to the API.
     *
     * @param emailAddress The email address for password recovery.
     * @return The Response object from the API.
     */
    public Response forgotPassword(String emailAddress) {
        validateBaseUri(); // Ensure base URI is set
        HashMap<String, String> body = new HashMap<>();
        body.put("email", emailAddress);

        return postRequest(body, BASE_PATH + "forgot-password");
    }

    /**
     * Validates if the base URI is set; throws an exception if not.
     */
    private void validateBaseUri() {
        if (baseUri == null || baseUri.isEmpty()) {
            throw new IllegalStateException("Base URI is not set. Use setBaseUri(String baseUri) to configure it.");
        }
    }
}
