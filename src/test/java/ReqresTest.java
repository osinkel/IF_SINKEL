import config.ConfigReader;
import models.reqres.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.ReqresSteps;

public class ReqresTest {

    ReqresSteps reqresSteps = new ReqresSteps();

    @Test
    @DisplayName("Проверить создание пользователя с данными из файла")
    public void checkUserCreation() {
        User user = reqresSteps.readUserFromFile(ConfigReader.getProp("reqres.data.user"));
        user.setName(ConfigReader.getProp("reqres.user.name"));
        user.setJob(ConfigReader.getProp("reqres.user.job"));
        User createdUser = reqresSteps.createNewUser(user);

        Assertions.assertEquals(user.getName(), createdUser.getName());
        Assertions.assertEquals(user.getJob(), createdUser.getJob());
    }
}
