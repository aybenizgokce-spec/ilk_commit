package testDatas;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestDatasHerOkuApp {
    public static int basariliStatusCode=200;

    /*
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
    {
    "bookingid": 24,
    "booking": {
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
}
     */

    public static JSONObject reqBodyOlustur() {
        JSONObject innerData = new JSONObject();
        innerData.put("checkin", "2021-06-01");
        innerData.put("checkout", "2021-06-10");
        JSONObject reqBody = new JSONObject();
        reqBody.put("firstname", "Ahmet");
        reqBody.put("lastname", "Bulut");
        reqBody.put("totalprice", 500);
        reqBody.put("depositpaid", false);
        reqBody.put("bookingdates", innerData);
        reqBody.put("additionalneeds", "wi-fi");
        return reqBody;
    }
    public static JSONObject exBodyOlustur(){
        JSONObject exBody=new JSONObject();
        exBody.put("bookingid",128);
        exBody.put("booking",reqBodyOlustur());
        return exBodyOlustur();
    }

    public static Map<String,Object> bookingMapOlustur(String checkin,String checkout){
    Map<String,Object> bookingMapData=new HashMap<>();
    bookingMapData.put("checkin",checkin);
    bookingMapData.put("checkout",checkout);
    return bookingMapData;
    }

    public static Map<String,Object> mapDataOlustur(){
        Map<String,Object> mapData=new HashMap<>();
        mapData.put("firstname","Murat");
        mapData.put("lastname","Babayiğit");
        mapData.put("totalprice",500.0);
        mapData.put("depositpaid",true);
        mapData.put("bookingdates",bookingMapOlustur("2025-05-01","2025-05-08"));
        mapData.put("additionalneeds","wi-fi");

        return mapData;
    }
    public static Map<String,Object> expDataOlustur(){
        Map<String,Object> expData=new HashMap<>();
        expData.put("bookingid",25.0);
        expData.put("booking",mapDataOlustur());

        return expData;
    }
}

