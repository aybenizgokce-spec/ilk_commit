package tests;

import BaseUrl.BaseUrlJsonPlace;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import pojos.POJO_Body_JPH;
import testDatas.TestDatasJPH;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class P15_PUT_PojoApiRequest extends BaseUrlJsonPlace {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine
asagidaki body'e sahip bir PUT request yolladigimizda
donen response'in
status kodunun 200,
content type'inin “application/json; charset=utf-8”,
Connection header degerinin “keep-alive”
ve response body'sinin asagida verilen ile ayni oldugunu test ediniz
Request Body
{
"title":"Ahmet",
"body":"Merhaba",
"userId":10,
"id":70
}
Response body : // expected data
{
"title":"Ahmet",
"body":"Merhaba",
"userId":10,
"id":70
}
     */

    @Test
    public void test(){
        specJsonPlace.pathParams("pp1","posts","pp2","70");
        POJO_Body_JPH reqBody=new POJO_Body_JPH("Ahmet","Merhaba",10,70);
        POJO_Body_JPH expBody=new POJO_Body_JPH("Ahmet","Merhaba",10,70);
        Response response=given().spec(specJsonPlace).contentType(ContentType.JSON).
                when().body(reqBody).put("/{pp1}/{pp2}");
        assertEquals(TestDatasJPH.basariliStatusCode,response.getStatusCode());
        assertEquals(TestDatasJPH.contentType,response.getContentType());
        assertEquals(TestDatasJPH.hConnectionHeader,response.getHeader("Connection"));
        POJO_Body_JPH resMap=response.as(POJO_Body_JPH.class);

        assertEquals(expBody.getTitle(),resMap.getTitle());
        assertEquals(expBody.getBody(),resMap.getBody());
        assertEquals(expBody.getUserId(),resMap.getUserId());
        assertEquals(expBody.getId(),resMap.getId());

    }
}
