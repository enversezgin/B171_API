package get_requests;

import baseUrl.ContactListBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get06 extends ContactListBaseUrl {

    /*          DAY 05 API
        Given
            https://thinking-tester-contact-list.herokuapp.com/contacts
        When
            Kullanıcı URL'e bir GET request gönderir
        Then
            HTTP Status Code 200 olmalı
        And
            Content Type "application/json" olmalı
     */

    @Test
    public void get06() {
        // Set the URL
        spec.pathParam("first", "contacts");    // uri dan sonra sadece bir endpoint old. için patParam seçildi (paramS seçilmedi)

        // Set the expected data

        // Send the request and get the response

        /*
        Response response = given(spec).header("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NTIxOWEwNDkyNjc2MzAwMTMxYmMyNGMiLCJpYXQiOjE2OTc1MzEzNzR9.UMMEb_xbeHW6gsjvFQqXhSN-8NOEt1CcxPyJWIXc9eU").when().get("{first}");

        Not : Bu bölüm kalabalık ve kullanışsız old. için TOKEN'ı alıp baseURL/ContactListBaseUrl içine yerleştirildi.
         */

        Response response = given(spec).when().get("{first}");


        response.prettyPrint();

        // Do assertion
        // Ödev
        response.then().statusCode(200);

    }
}

//