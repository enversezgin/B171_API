package gmi_bank;

import baseUrl.GmiBankBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.gmibank.*;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetCustomer extends GmiBankBaseUrl {
        /*
        Given
            https://www.gmibank.com/api/tp-customers/133986
        When
            User sends Get request
        Then
            Status code should be 200
         And
            Response body should be like:
                {
                    "id": 133986,
                    "firstName": "Danika",
                    "lastName": "Huel",
                    "middleInitial": "S",
                    "email": "danikahuel@gmail.com",
                    "mobilePhoneNumber": "155-489-7844",
                    "phoneNumber": "155-489-7844",
                    "zipCode": "32476",
                    "address": "3848 Lang Hill",
                    "city": "Free City",
                    "ssn": "725-97-6213",
                    "createDate": "2022-01-21T05:00:00Z",
                    "zelleEnrolled": false,
                    "country": {
                        "id": 187679,
                        "name": "Banana",
                        "states": null
                    },
                    "state": "Apple",
                    "user": {
                        "id": 134701,
                        "login": "raymundo.moen",
                        "firstName": "Danika",
                        "lastName": "Huel",
                        "email": "danikahuel@gmail.com",
                        "activated": true,
                        "langKey": "en",
                        "imageUrl": null,
                        "resetDate": null
                    },
                    "accounts": [
                        {
                            "id": 128481,
                            "description": "Description",
                            "balance": 0,
                            "accountType": "CHECKING",
                            "accountStatusType": "ACTIVE",
                            "createDate": "2022-01-04T21:00:00Z",
                            "closedDate": "2022-01-04T21:00:00Z",
                            "employee": null,
                            "accountlogs": null
                        },
                        {
                            "id": 131776,
                            "description": "mfy",
                            "balance": 536846,
                            "accountType": "CREDIT_CARD",
                            "accountStatusType": "ACTIVE",
                            "createDate": "2022-01-18T21:00:00Z",
                            "closedDate": "2022-01-18T21:00:00Z",
                            "employee": null,
                            "accountlogs": null
                        }
                    ]
                }
         */

    @Test
    public void getCustomer() {
        spec.pathParams("first","api","second","tp-customers", "third", 133986);

        // Set the expected data
        GetCountryPojo country = new GetCountryPojo(187679, "Banana", null);

        UserPojo user = new UserPojo(134701, "raymundo.moen", "Danika",  "Huel", "danikahuel@gmail.com",
                true, "en", null, null);
        AccountsPojo accounts1 = new AccountsPojo(128481, "Description", 0, "CHECKING",
                "ACTIVE", "2022-01-04T21:00:00Z", "2022-01-04T21:00:00Z", null,null);
        AccountsPojo accounts2 = new AccountsPojo(131776, "mfy", 536846, "CREDIT_CARD",
                "ACTIVE", "2022-01-18T21:00:00Z", "2022-01-18T21:00:00Z", null, null);
        List<AccountsPojo> accountsList = new ArrayList<>();
        accountsList.add(accounts1);
        accountsList.add(accounts2);
        CustomerPojo expectedData = new CustomerPojo(133986, "Danika", "Huel", "S",
                "danikahuel@gmail.com", "155-489-7844", "155-489-7844",
                "32476", "3848 Lang Hill", "Free City", "725-97-6213", "2022-01-21T05:00:00Z",
                false, country, "Apple", user, accountsList);

        Response response = given(spec).when().get("{first}/{second}/{third}");
        response.prettyPrint();

        CustomerPojo actualDataCustomer = response.as(CustomerPojo.class);
        //System.out.println(actualDataCustomer);

       assertEquals(200,response.statusCode());

       assertEquals(expectedData.getId(),               actualDataCustomer.getId());
       assertEquals(expectedData.getFirstName(),        actualDataCustomer.getFirstName());
       assertEquals(expectedData.getLastName(),         actualDataCustomer.getLastName());
       assertEquals(expectedData.getMiddleInitial(),    actualDataCustomer.getMiddleInitial());
       assertEquals(expectedData.getEmail(),            actualDataCustomer.getEmail());
       assertEquals(expectedData.getMobilePhoneNumber(),actualDataCustomer.getMobilePhoneNumber());
       assertEquals(expectedData.getPhoneNumber(),      actualDataCustomer.getPhoneNumber());
       assertEquals(expectedData.getZipCode(),          actualDataCustomer.getZipCode());
       assertEquals(expectedData.getAddress(),          actualDataCustomer.getAddress());
       assertEquals(expectedData.getCity(),             actualDataCustomer.getCity());
       assertEquals(expectedData.getSsn(),              actualDataCustomer.getSsn());
       assertEquals(expectedData.getCreateDate(),       actualDataCustomer.getCreateDate());
       assertEquals(expectedData.isZelleEnrolled(),     actualDataCustomer.isZelleEnrolled());
       assertEquals(expectedData.getState(),            actualDataCustomer.getState());

       assertEquals(expectedData.getCountry().getId(),    actualDataCustomer.getCountry().getId());
       assertEquals(expectedData.getCountry().getName(),  actualDataCustomer.getCountry().getName());
       assertEquals(expectedData.getCountry().getStates(),actualDataCustomer.getCountry().getStates());

       assertEquals(expectedData.getUser().getId(),       actualDataCustomer.getUser().getId());
       assertEquals(expectedData.getUser().getLogin(),    actualDataCustomer.getUser().getLogin());
       assertEquals(expectedData.getUser().getFirstName(),actualDataCustomer.getUser().getFirstName());
       assertEquals(expectedData.getUser().getLastName(), actualDataCustomer.getUser().getLastName());
       assertEquals(expectedData.getUser().getEmail(),    actualDataCustomer.getUser().getEmail());
       assertEquals(expectedData.getUser().getLangKey(),  actualDataCustomer.getUser().getLangKey());
       assertEquals(expectedData.getUser().getImageUrl(), actualDataCustomer.getUser().getImageUrl());
       assertEquals(expectedData.getUser().getResetDate(),actualDataCustomer.getUser().getResetDate());

       assertEquals(accounts1.getId(),               actualDataCustomer.getAccounts().get(0).getId());
       assertEquals(accounts1.getDescription(),      actualDataCustomer.getAccounts().get(0).getDescription());
       assertEquals(accounts1.getBalance(),          actualDataCustomer.getAccounts().get(0).getBalance());
       assertEquals(accounts1.getAccountType(),      actualDataCustomer.getAccounts().get(0).getAccountType());
       assertEquals(accounts1.getAccountStatusType(),actualDataCustomer.getAccounts().get(0).getAccountStatusType());
       assertEquals(accounts1.getCreateDate(),       actualDataCustomer.getAccounts().get(0).getCreateDate());
       assertEquals(accounts1.getClosedDate(),       actualDataCustomer.getAccounts().get(0).getClosedDate());
       assertEquals(accounts1.getEmployee(),         actualDataCustomer.getAccounts().get(0).getEmployee());
       assertEquals(accounts1.getAccountlogs(),      actualDataCustomer.getAccounts().get(0).getAccountlogs());

       assertEquals(accounts2.getId(),               actualDataCustomer.getAccounts().get(1).getId());
       assertEquals(accounts2.getDescription(),      actualDataCustomer.getAccounts().get(1).getDescription());
       assertEquals(accounts2.getBalance(),          actualDataCustomer.getAccounts().get(1).getBalance());
       assertEquals(accounts2.getAccountType(),      actualDataCustomer.getAccounts().get(1).getAccountType());
       assertEquals(accounts2.getAccountStatusType(),actualDataCustomer.getAccounts().get(1).getAccountStatusType());
       assertEquals(accounts2.getCreateDate(),       actualDataCustomer.getAccounts().get(1).getCreateDate());
       assertEquals(accounts2.getClosedDate(),       actualDataCustomer.getAccounts().get(1).getClosedDate());
       assertEquals(accounts2.getEmployee(),         actualDataCustomer.getAccounts().get(1).getEmployee());
       assertEquals(accounts2.getAccountlogs(),      actualDataCustomer.getAccounts().get(1).getAccountlogs());

        System.out.println("Ödev Tamamladi");












    }
}
