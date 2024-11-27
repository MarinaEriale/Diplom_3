package user;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {
    public Response login (User user) {
        return given()
                .log().all()
                .header("Content-type", "application/json")
                .body(user)
                .when()
                .post("/api/auth/login");
    }

    public Response delete (String token) {
        return given()
                .log().all()
                .headers(
                        "Content-type", "application/json",
                        "Authorization", token)
                .and()
                .delete("/api/auth/user");
    }
}
