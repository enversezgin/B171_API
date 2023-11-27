package herokuapp_smoketest;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.herokuapp.BookingDatesPojo;
import pojos.herokuapp.BookingPojo;
import test_data.HerokuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static herokuapp_smoketest.TC01_CreateBooking.bookingId;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class TC04_PartialUpdateBooking extends HerokuAppBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/:id
    And
        {
            "firstname" : "Enver",
            "lastname" : "SEZGIN"
        }
    When
        Kullanıcı PATCH Request gönderir
    Then
        Status Code: 200
    And
        {
            "firstname" : "Enver",
            "lastname" : "SEZGIN",
            "totalprice" : 111,
            "depositpaid" : true,
            "bookingdates" : {
                "checkin" : "2018-01-01",
                "checkout" : "2019-01-01"
            },
            "additionalneeds" : "Breakfast"
        }


     */

    @Test
    public void partialUpdateBooking() {
        spec.pathParams("first", "booking", "second", bookingId);

        HerokuAppTestData obj = new HerokuAppTestData();
        Map<String, Object> payLoad = obj.getPayLoad("Enver", "SEZGIN", null, null, null, null);

        Response response = given(spec).body(payLoad).when().patch("{first}/{second}");
        response.prettyPrint();

        Map<String, Object> actualData = response.as(HashMap.class);
        assertEquals(200, response.statusCode());
        assertEquals(payLoad.get("firstname"), actualData.get("firstname"));
        assertEquals(payLoad.get("lastname"), actualData.get("lastname"));

    }
}

//14 Ekim

/*

 * Post işleminde oluşturduğumuz datanın ID'sini aldık.
 * jsonPath kullanarak bookingId değişkeninde ID değerimizi aldık
 * Daha sonra bu değeri get,update,patchupdate de kullandık
 * Id'yi aldık containeri koyduk
 * Runner class kullandık. Çünkü manuel olarak çalıştırınca datalar bellekten siler. Sıfırlanmaması için hafızada yer koruması lazım
 * Runner'dan çalıştırınca bütün testler sona erdikten sonra konsolda en aşağıda finish yazar.
 * partialUpdate'de Mapleri kullanmanın daha avantajlı olduğunu gördük

   */