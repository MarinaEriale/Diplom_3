package user;

import io.restassured.response.Response;

import static constants.UserEndpoints.LOGIN;
import static constants.UserEndpoints.USER;
import static io.restassured.RestAssured.given;

public class UserClient {
    public Response login (User user) {
        return given()
                .log().all()
                .header("Content-type", "application/json")
                .body(user)
                .when()
                .post(LOGIN);
    }

    public Response delete (String token) {
        return given()
                .log().all()
                .headers(
                        "Content-type", "application/json",
                        "Authorization", token)
                .and()
                .delete(USER);
    }
}
