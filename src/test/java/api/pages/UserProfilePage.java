package api.pages;

import api.base.UserProfileManagementService;
import io.restassured.response.Response;

public class UserProfilePage {

    private UserProfileManagementService userProfileManagementService;

    public UserProfilePage(String baseUri) {
        this.userProfileManagementService = new UserProfileManagementService();
        this.userProfileManagementService.setBaseUri(baseUri); // Dynamically set the base URI
    }

    /**
     * Sends a request to get the user profile.
     *
     * @param token The Bearer token for authentication.
     * @return The Response object from the API.
     */
    public Response getUserProfile(String token) {
        return userProfileManagementService.getProfile(token);
    }
}
