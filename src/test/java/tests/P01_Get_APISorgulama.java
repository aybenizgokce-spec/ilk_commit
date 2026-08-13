package tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class P01_Get_APISorgulama {

    @Test
    public void test(){
    /*
    Tum API testleri 4 aşamada gerçekleşir
    1-Endpoint ve varsa request Body(Put-PostPatch) hazırlama
    2-Soruda bize verilmiş ise expectedBody hazırlama
    3-Response kayıt altına alma
    4-Assertion işlemleri
     */
    /*
    https://restful-booker.herokuapp.com/booking/10 url'ine

    bir GET request gonderdigimizde donen Response'un,

    status code'unun 200,

    ve content type'inin application/json; charset=utf-8,

    ve Server isimli Header'in degerinin Cowboy,

    ve status Line'in HTTP/1.1 200 OK

    ve response suresinin 5 sn'den kısa oldugunu manuel olarak test ediniz.

*/
        //endpoind hazırlama
        String url="https://restful-booker.herokuapp.com/booking/10";

        //response body soruda verilmediği için expected data hazırlanmadı

        //Response kayıt altına alınır
        Response response=given().when().get(url);

        //response.prettyPrint(); //sorguda dönen cevabın içeriğini yazdırır
        //response.prettyPeek(); //sorgunun tüm bilgileri ile içeriğini yazdırır

        //Assertion işlemleri
        //response.then().assertThat().statusCode(200);

        //Manuel Kontrol
//        System.out.println(response.getStatusCode());  200
//        System.out.println(response.getContentType()); application/json; charset=utf-8
//        System.out.println(response.getHeader("Server")); Heroku
//        System.out.println(response.getStatusLine()); HTTP/1.1 200 OK
//        System.out.println(response.getTime()); 1510

        //Otomasyonla kontrol
        response.then().assertThat().statusCode(200).contentType("application/json; charset=utf-8")
                .statusLine("HTTP/1.1 200 OK").header("Server","Heroku");


}}
