package testDatas;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestDatasJPH {
    public  static int basariliStatusCode=200;
    public static String contentType="application/json; charset=utf-8";
    public static String hConnectionHeader="keep-alive";
    /*
{
    "userId": 3,
    "id": 22,
    "title": "dolor sint quo a velit explicabo quia nam",
    "body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\n\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
}
*/
    public static JSONObject jphExpDataOlustur(){
        JSONObject expData=new JSONObject();
        expData.put( "userId", 3);
        expData.put("id", 22);
        expData.put("title", "dolor sint quo a velit explicabo quia nam");
        expData.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio" +
                "\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");
        return expData;

    }

    /*
      "title": "Ahmet",
        "body": "Merhaba",
        "userId": 10,
        "id": 70
     */
    public static Map<String, Object> jphMapDataOlustur(Object title, Object body, Object userId, Object id){
        Map<String, Object> MapData = new HashMap<>();
        MapData.put("title", title);
        MapData.put("body", body);
        MapData.put("userId", userId);
        MapData.put("id", id);

        return MapData;
    }
    public static Map<String, Object> jphMapDataOlusturPli(String title, String body, double userId, double id){
        Map<String, Object> MapData = new HashMap<>();
        MapData.put("title", title);
        MapData.put("body", body);
        MapData.put("userId", userId);
        MapData.put("id", id);

        return MapData;
    }
}
