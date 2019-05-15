import io.restassured.RestAssured;
import org.junit.Test;


import static io.restassured.RestAssured.given;

public class GetClientInfoByIdTest {
    public String idMale = "11";
    public int integers = 3;
    public String nonExistent = "tttttttttttttttttttt";
    public String empty = "";
    public String nulled = "null";
    public String idFemale = "15";
/*
результатом этих двух тестов должно быть 200 ОК и result с данными
 */
    @Test
    public void runsuccessful() {
        searchSuccessfultest(idMale);
        searchSuccessfultest(idFemale);

    }
/*
результатом этих тестов должно быть по идее 400 bad params для первого,
404 not found для 2-3 и не упасть для четвертого.
 */
    @Test
    public void runFailing() {
        searchFailtest(integers);
        searchFailtest(nonExistent);
        searchFailtest(empty);
        searchFailtest(nulled);
    }

    public void searchSuccessfultest(Object id) {
        RestAssured.baseURI = "https://dev.coolrocket.com/test/";
        given()
                .params("id", id)
                .get("user")
                .then().assertThat().statusCode(200)
                .log().all().extract().response();
    }

    public void searchFailtest(Object id) {
        RestAssured.baseURI = "https://dev.coolrocket.com/test/";
        given()
                .params("id", id)
                .get("user")
                .then().assertThat().statusCode(404)
                .log().all().extract().response();
    }
}
