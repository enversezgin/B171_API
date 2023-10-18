package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import static utils.AuthenticationContactList.generateToken;


public class ContactListBaseUrl {

    protected RequestSpecification spec;

    @Before
    public void setup() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://thinking-tester-contact-list.herokuapp.com")

                //.addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NTIxOWEwNDkyNjc2MzAwMTMxYmMyNGMiLCJpYXQiOjE2OTc1MzEzNzR9.UMMEb_xbeHW6gsjvFQqXhSN-8NOEt1CcxPyJWIXc9eU")
                // bu şekilde de Authentication hard old. her login de bayatlayacağı  için aşağıdaki yol kullanılır.
                .addHeader("Authorization","Bearer " + generateToken())
                .build();
    }
}