package api.pages;

import api.base.UserProfileManagementService;
import api.models.requests.ProfileRequest;
import api.models.response.UserProfileResponse;
import io.restassured.response.Response;

public class UpdateProfilePage {

    private UserProfileManagementService userProfileManagementService;

    public UpdateProfilePage() {
        userProfileManagementService = new UserProfileManagementService(); // Initialize service
    }

    /**
     * Retrieves the current profile information using the provided token.
     * @param token The Bearer token for authentication.
     * @return The current profile information.
     */
    public UserProfileResponse getProfile(String token) {
        Response response = userProfileManagementService.getProfile(token);
        return response.as(UserProfileResponse.class);
    }

    /**
     * Updates the user profile with the provided details and token.
     * @param token The Bearer token for authentication.
     * @param profileRequest The new profile details to update.
     * @return The response of the update operation.
     */
    public Response updateProfile(String token, ProfileRequest profileRequest) {
        return userProfileManagementService.updateProfile(token, profileRequest);
    }
}
