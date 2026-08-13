package tests;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class P02_JsonDataOlusturma {
    /*
Asagidaki JSON Objesini olusturup konsolda yazdirin.

{

"title":"Ahmet",

"body":"Merhaba",

"userId":1

}
     */

    @Test
    public void JsonDataCreate(){
        JSONObject data=new JSONObject();
        data.put("title","Ahmet");
        data.put("body","Merhaba");
        data.put("userId",1);
        System.out.println(data);
    }
    /*
    {
"firstname":"Jim",
"lastname":"Brown",
"totalprice":111,
"depositpaid":true,
"bookingdates":{
"checkin":"2018-01-01",
"checkout":"2019-01-01"
},
"additionalneeds":"Breakfast"
}
     */

    //iç içe dataların bulunduğu verilerde biz en içtekini oluşturarak başlarız

    @Test
    public void jsonDataOlusturma(){
        JSONObject bookingDates=new JSONObject();
        bookingDates.put("checkin","2018-01-01");
        bookingDates.put("checkout","2019-01-01");

        JSONObject data=new JSONObject();
        data.put("firstname","Jim");
        data.put("lastname","Brown");
        data.put("totalprice",111);
        data.put("depositpaid",true);
        data.put("bookingDates",bookingDates);
        data.put("additionalneeds","Breakfast");
        System.out.println(data);

    }


}
