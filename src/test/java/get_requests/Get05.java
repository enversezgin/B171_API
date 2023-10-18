package get_requests;

import baseUrl.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;                  // . dan sonra * konduğunda o class a ait tüm importları yapmış olur.

public class Get05 extends PetStoreBaseUrl {
    /*
        Given
            https://petstore.swagger.io/v2/pet/findByStatus?status=available
        When
            Kullanıcı URL'e bir GET request gönderir
        Then
            HTTP Status Code 200 olmalı
        And
            Content Type "application/json" olmalı
        And
            Listede id değeri 9898 olan bir eleman olmalı
        And
            Listede name değeri "Pamuk" olan bir eleman olmalı
        And
            Listede name değerleri "Pamuk", "doggie", "fish" olan elemanlar olmalı
        And
            Listede en az 200 tane eleman olmalı
        And
            Listede 500'den az eleman olmalı
        And
            Listenin ilk elemanının category - id değeri 0 olmalı
        And
            Listenin ilk elemanının photoUrls değeri "string" olmalı
        And
            Listenin ilk elemanının tag - id değeri 0 olmalı
     */

    @Test
    public void get05() {
        // Set the URL
        spec.pathParams("first", "pet", "second", "findByStatus")
                .queryParam("status", "available");

        // Set the expected data

        // Send the request and get the response
        Response response = given(spec).when().get("{first}/{second}"); // get in içine format olarak "{}/{}/{}/{}" kullanılır
        response.prettyPrint();

        // Do assertion
        response
                .then()
                .statusCode(200)        //satır 18
                .contentType(ContentType.JSON)      //satır 20
                .body("id", hasItem(9898))          //satır 22
                .body("name", hasItem("Pamuk"))         //satır 24
                .body("name", hasItems("Pamuk", "doggie", "fish"))      //satır 26
                .body("id", hasSize(greaterThan(200)))            //satır 28
                .body("id", hasSize(lessThan(500)))               //satır 30
                .body("[0].category.id", equalTo(0))            //satır 32   ==> .body("category.id", equalTo(0)) yazmayız sebebi category'nin artık bir listin içinde olması o yüzden [] ile array değerini belirtmeliyiz.
                .body("[0].photoUrls[0]", equalTo("string"))    //satır 34
                .body("[0].tags[0].id", equalTo(0));            //satır 36
    }
}

//