package apitests;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Tests {

    @Test
    public void list_All_Post_Resources(){
        given().
                when().
                get("https://jsonplaceholder.typicode.com/posts").
                then().
                assertThat().
                statusCode(200).
                log().all();
    }

    @Test
    public void single_Posts_Resource_With_Id_Equals_Eleven() {
        given().
                when().
                get("https://jsonplaceholder.typicode.com/posts/11").
                then().
                assertThat().
                statusCode(200).
                log().all();
    }

    @Test
    public void post_Request_To_Create_A_New_Posts_Resource(){
        JsonObject body = new JsonObject();
        body.addProperty("title", "foo");
        body.addProperty("body", "bar");
        body.addProperty("userId", 1);

        given().
                body(body.toString()).
                log().all().
                when().
                post("https://jsonplaceholder.typicode.com/posts").
                then().
                assertThat().
                statusCode(201);


    }
    @Test
    public void delete_Posts_Request_With_Id_Equals_One(){
        given().
                when().
                delete("https://jsonplaceholder.typicode.com/posts/1").
                then().
                assertThat().
                statusCode(200).
                log().all();
    }
}
