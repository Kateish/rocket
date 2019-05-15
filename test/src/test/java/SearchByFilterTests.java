import io.restassured.RestAssured;
import org.junit.Test;


import static io.restassured.RestAssured.given;

public class SearchByFilterTests {
    private String male = "male";
    private String female = "female";

    @Test
    public void run(){
        testGet(male);
        testGet(female);
    }
    public void testGet(String gender) {
        RestAssured.baseURI = "https://dev.coolrocket.com/test/";
        given()
                .params("gender", gender)
                .get("users")
                .then().assertThat().statusCode(200)
                .log().all().extract().response();
    }

}
