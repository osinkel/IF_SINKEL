package api.reqres;

import config.ConfigReader;
import io.restassured.response.ValidatableResponse;
import models.reqres.User;

import static io.restassured.RestAssured.given;

public class ReqresApi extends BaseReqresApi {

    private static final String USERS_ENDPOINT = ConfigReader.getProp("reqres.api.endpoints.users");

    public ValidatableResponse createUser(User user) {
        return given()
                .when()
                .body(user)
                .post(USERS_ENDPOINT)
                .then();
    }
}
