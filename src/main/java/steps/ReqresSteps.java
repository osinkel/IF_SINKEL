package steps;

import api.reqres.ReqresApi;
import models.reqres.User;
import org.apache.http.HttpStatus;
import utils.MapperUtils;

public class ReqresSteps {

    private static final ReqresApi reqresApi = new ReqresApi();

    public User readUserFromFile(String filePath) {
        return MapperUtils.readFromFile(filePath, User.class);
    }

    public User createNewUser(User user) {
        return reqresApi.createUser(user)
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .body()
                .as(User.class);
    }
}
