package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import static utils.AuthenticationContactList.generateToken;


public class JsonPlaceHolderBaseUrl{

    protected RequestSpecification spec;

    @Before
    public void setup() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://jsonplaceholder.typicode.com/todos")
                .addHeader("Authorization","Bearer " + generateToken())
                .build();
    }
}