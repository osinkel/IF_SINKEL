package api.reqres;

import api.Specifications;
import constants.EnvConstants;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;

public abstract class BaseReqresApi {
    public BaseReqresApi() {
        RestAssured.requestSpecification = Specifications.baseRequestSpec(EnvConstants.REQRES_URL);
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }
}