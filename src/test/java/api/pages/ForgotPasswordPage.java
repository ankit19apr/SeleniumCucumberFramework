package api.pages;

import api.base.AuthService;
import io.restassured.response.Response;

public class ForgotPasswordPage {

    private AuthService authService;

    public ForgotPasswordPage(String baseUri) {
        this.authService = new AuthService();
        this.authService.setBaseUri(baseUri); // Dynamically set the base URI
    }

    /**
     * Sends a request to reset the password for the given email.
     *
     * @param email The email address for which the password reset is requested.
     * @return The Response object from the API.
     */
    public Response resetPassword(String email) {
        return authService.forgotPassword(email);
    }
}
