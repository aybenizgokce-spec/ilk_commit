package tests;

import BaseUrl.BaseUrlHerOkuApp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testDatas.TestDatasHerOkuApp;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class P14_POST_deSerazilation extends BaseUrlHerOkuApp {
    /*
    https://restful-booker.herokuapp.com/booking url'ine
    asagidaki body'e sahip bir POST request gonderdigimizde
    donen response'in id haric asagidaki gibi oldugunu test edin.
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
    "bookingid":24,
    "booking":{
        "firstname":"Ahmet",
        "lastname":"Bulut",
        "totalprice":500,
        "depositpaid":false,
        "bookingdates":{
            "checkin":"2021-06-01",
            "checkout":"2021-06-10"
        }
        ,
        "additionalneeds":"wi-fi"
    }
    }
    */
    @Test
    public void test(){
        spectRestfull.pathParam("pp1","booking");
        Map<String,Object> reqMapBody= TestDatasHerOkuApp.mapDataOlustur();
        Map<String,Object> expMapBody=TestDatasHerOkuApp.expDataOlustur();
        Response response=given().spec(spectRestfull).contentType(ContentType.JSON).when().body(reqMapBody).post("/{pp1}");
        assertEquals(TestDatasHerOkuApp.basariliStatusCode,response.getStatusCode());
        Map<String,Object> resMap=response.as(HashMap.class);
        assertEquals(((Map)expMapBody.get("booking")).get("firstname"),((Map)resMap.get("booking")).get("firstname"));
        assertEquals(((Map)expMapBody.get("booking")).get("lastname"),((Map)resMap.get("booking")).get("lastname"));
        assertEquals(((Map)expMapBody.get("booking")).get("totalprice"),((Map)resMap.get("booking")).get("totalprice"));
        assertEquals(((Map)expMapBody.get("booking")).get("additionalneeds"),((Map)resMap.get("booking")).get("additionalneeds"));
        assertEquals(((Map)expMapBody.get("booking")).get("depositpaid"),((Map)resMap.get("booking")).get("depositpaid"));
        assertEquals(((Map)((Map)expMapBody.get("booking")).get("bookingdates")).get("checkin"),((Map)((Map)resMap.get("booking")).get("bookingdates")).get("checkin"));
        assertEquals(((Map)((Map)expMapBody.get("booking")).get("bookingdates")).get("checkout"),((Map)((Map)resMap.get("booking")).get("bookingdates")).get("checkout"));

    }
}
