package api.reqres;

import api.BaseApi;
import config.ConfigReader;
import constants.EnvConstants;
import io.restassured.response.ValidatableResponse;
import models.reqres.User;

import static io.restassured.RestAssured.given;

public class ReqresApi extends BaseApi {

    private static final String USERS_ENDPOINT = ConfigReader.getProp("reqres.api.endpoints.users");

    public ReqresApi() {
        super(EnvConstants.REQRES_URL);
    }

    public ValidatableResponse createUser(User user) {
        return given()
                .when()
                .body(user)
                .post(USERS_ENDPOINT)
                .then();
    }
}
