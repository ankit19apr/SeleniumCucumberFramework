package api.base;

import api.models.requests.ProfileRequest;
import io.restassured.response.Response;

public class UserProfileManagementService extends BaseService {

    private String basePath = "/api/users"; // Default base path for user profile management

    // Constructor with optional base URI, falls back to default URI in BaseService
    public UserProfileManagementService(String baseUri) {
        super(baseUri);  // Pass baseUri to BaseService constructor to initialize the base URI
    }

    // Default constructor to use default base URI
    public UserProfileManagementService() {
        super();  // Uses the default constructor from BaseService
    }

    /**
     * Sets the base path for the User Profile Management Service.
     * This allows flexibility to override the default base path if needed.
     *
     * @param basePath The new base path to be set.
     */
    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    /**
     * Sets the base URI for the API requests dynamically.
     * This allows the base URI to be set independently of the base path.
     *
     * @param baseUri The new base URI to be set.
     */
    public void setBaseUri(String baseUri) {
        super.setBaseUri(baseUri); // Call the setBaseUri method from BaseService
    }

    /**
     * Retrieves the user profile using the provided authentication token.
     * This method sends a GET request to fetch the profile data.
     *
     * @param token The Bearer token for authentication.
     * @return The Response object containing the user profile information.
     */
    public Response getProfile(String token) {
        setAuthToken(token); // Set the authorization token for the request
        return getRequest(basePath + "/profile"); // Send the GET request to fetch the profile
    }

    /**
     * Updates the user profile with the given details and authentication token.
     * This method sends a PUT request to update the profile.
     *
     * @param token The Bearer token for authentication.
     * @param body  The ProfileRequest object containing updated profile information.
     * @return The Response object from the API.
     */
    public Response updateProfile(String token, ProfileRequest body) {
        setAuthToken(token); // Set the authorization token for the request
        return putRequest(body, basePath + "/profile"); // Send the PUT request to update the profile
    }
}
