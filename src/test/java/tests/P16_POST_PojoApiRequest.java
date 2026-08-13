package tests;

import BaseUrl.BaseUrlHerOkuApp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import pojos.POJO_InnerPojo_JPH;
import pojos.POJO_RequestBodyPojo_JPH;
import pojos.POJO_expBodyPojo_JPH;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class P16_POST_PojoApiRequest extends BaseUrlHerOkuApp {
    /*
    https://restful-booker.herokuapp.com/booking url'ine
asagidaki body'e sahip bir POST request gonderdigimizde
donen response'un id haric asagidaki gibi oldugunu test edin.

Request body
{
    "firstname" : "Ahmet",
    "lastname" : "Bulut",
    "totalprice" : 500,
    "depositpaid" : false,
    "bookingdates" : {
        "checkin" : "2021-06-01",
        "checkout" : "2021-06-10"
    },
    "additionalneeds" : "wi-fi"
}

Response Body // expected data
{
    "bookingid": 24,
    "booking": {
        "firstname": "Ahmet",
        "lastname": "Bulut",
        "totalprice": 500,
        "depositpaid": false,
        "bookingdates": {
            "checkin": "2021-06-01",
            "checkout": "2021-06-10"
        },
        "additionalneeds": "wi-fi"
    }
     */

    @Test
    public void test(){
        spectRestfull.pathParam("pp1", "booking");
        POJO_InnerPojo_JPH bookingdates=new POJO_InnerPojo_JPH("2025-01-01", "2025-01-10");
        POJO_RequestBodyPojo_JPH reqBody=new POJO_RequestBodyPojo_JPH("Murat","Babayiğit", 500, true, bookingdates, "wi-fi");
        POJO_expBodyPojo_JPH expBody=new POJO_expBodyPojo_JPH(24,reqBody);
        Response response=given().spec(spectRestfull).contentType(ContentType.JSON).when().body(reqBody).post("/{pp1}");

        POJO_expBodyPojo_JPH resPojo=response.as(POJO_expBodyPojo_JPH.class);
        assertEquals(expBody.getBooking().getFirstname(),resPojo.getBooking().getFirstname());
        assertEquals(expBody.getBooking().getLastname(),resPojo.getBooking().getLastname());
        assertEquals(expBody.getBooking().getTotalprice(),resPojo.getBooking().getTotalprice());
        assertEquals(expBody.getBooking().isDepositpaid(),resPojo.getBooking().isDepositpaid());
        assertEquals(expBody.getBooking().getAdditionalneeds(),resPojo.getBooking().getAdditionalneeds());
        assertEquals(expBody.getBooking().getBookingdates().getCheckin(),resPojo.getBooking().getBookingdates().getCheckin());
        assertEquals(expBody.getBooking().getBookingdates().getCheckout(),resPojo.getBooking().getBookingdates().getCheckout());

    }
}
