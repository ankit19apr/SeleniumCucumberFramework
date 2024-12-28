package api.stepDefinitions;

import api.pages.UpdateProfilePage;
import api.models.requests.ProfileRequest;
import api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class UpdateProfileStep{

    private String token;
    private UpdateProfilePage updateProfilePage;
    private UserProfileResponse userProfileResponse;
    private Response response;

    public UpdateProfileStep() {
        updateProfilePage = new UpdateProfilePage(); // Initialize page class
    }



    @When("the user retrieves their profile information")
    public void the_user_retrieves_their_profile_information() {
        userProfileResponse = updateProfilePage.getProfile(token); // Use the page class method to get profile
    }

    @Then("the username in the profile should be {string}")
    public void the_username_in_the_profile_should_be(String expectedUsername) {
        Assert.assertEquals(userProfileResponse.getUsername(), expectedUsername); // Verify username
    }

    @When("the user updates their profile with first name {string}, last name {string}, email {string}, and mobile number {string}")
    public void the_user_updates_their_profile_with_first_name_last_name_email_and_mobile_number(
            String firstName, String lastName, String email, String mobileNumber) {

        ProfileRequest profileRequest = new ProfileRequest.Builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .mobileNumber(mobileNumber)
                .build();

        response = updateProfilePage.updateProfile(token, profileRequest); // Use page class method to update profile
    }

    @Then("the profile should be updated with first name {string}, last name {string}, email {string}, and mobile number {string}")
    public void the_profile_should_be_updated_with_first_name_last_name_email_and_mobile_number(
            String expectedFirstName, String expectedLastName, String expectedEmail, String expectedMobileNumber) {

        // Fetch updated profile and validate
        userProfileResponse = response.as(UserProfileResponse.class);
        Assert.assertEquals(userProfileResponse.getFirstName(), expectedFirstName);
        Assert.assertEquals(userProfileResponse.getLastName(), expectedLastName);
        Assert.assertEquals(userProfileResponse.getEmail(), expectedEmail);
        Assert.assertEquals(userProfileResponse.getMobileNumber(), expectedMobileNumber);
    }
}
