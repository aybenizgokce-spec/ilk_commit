package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class P05_Get_ApiSorgulama {
    /*
https://restful-booker.herokuapp.com/booking/10 url'ine bir GET request gonderdigimizde donen Response'un,
status code'unun 200,
ve content type'inin application-json,
ve response body'sindeki
"firstname"in,"Susan",
ve "lastname"in, "Jackson",
ve "totalprice"in,612,
ve "depositpaid"in,false,
ve "additionalneeds"in,"Breakfast"
oldugunu test edin
*/
    @Test
    public void test01(){
        String url="https://restful-booker.herokuapp.com/booking/10";
        Response response=given().when().get(url);
        response.then().assertThat().statusCode(200).contentType("application/json")
                .body("firstname", equalTo("Susan"),
                        "lastname",equalTo("Jackson"),
                        "totalprice",equalTo(612),
                        "depositpaid",equalTo(false),
                        "additionalneeds",equalTo("Breakfast"));


        //https://reqres.in       örneklerle kendini deneyebileceğin bir test sitesi
    }
}
