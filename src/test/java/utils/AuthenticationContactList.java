package utils;

import io.restassured.response.Response;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;

public class AuthenticationContactList {
                                             //       public static void main(String[] args) {
                                             //           System.out.println(genereteToken());
                                             //       }

    public static String generateToken(){
        String body = "{\n" +
                "    \"email\": \"tobias.jauan@free2ducks.com\", \n" +
                "    \"password\": \"123/*-qwe\"\n" +
                "}";

        Response response = given().body(body)
                .contentType(ContentType.JSON)
                .when()
                .post("https://thinking-tester-contact-list.herokuapp.com/users/login");
                //         response.prettyPrint();
        return response.jsonPath().getString("token");
    }
}
