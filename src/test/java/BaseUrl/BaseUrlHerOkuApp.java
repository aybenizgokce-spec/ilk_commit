package BaseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;

public class BaseUrlHerOkuApp {
    protected RequestSpecification spectRestfull;
    @BeforeEach
    public void setup(){
        spectRestfull =new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
    }
}
