package steps;

import api.reqres.ReqresApi;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Allure;
import models.reqres.User;
import org.apache.http.HttpStatus;
import utils.MapperUtils;

public class ReqresSteps {

    private User userFromFile;
    private User userReqres;

    private static final ReqresApi reqresApi = new ReqresApi();

    @Допустим("создан объект User c данными из json файла {string}")
    public void readUserFromFile(String filePath) {
        userFromFile = MapperUtils.readFromFile(filePath, User.class);
        Allure.addAttachment("Пользователь созданный из файла", userFromFile.toString());
    }

    @И("сменить созданному пользомателю имя на {string} и работу на {string}")
    public void changeUserNameAndJob(String name, String job) {
        userFromFile.setName(name);
        userFromFile.setJob(job);
        Allure.addAttachment("Измененный пользователь из файла", userFromFile.toString());
    }

    @Тогда("проверить, что пользователь с измененными данными из файла успешно создан")
    public void checkCreatedUser() {
        Allure.addAttachment("Измененный пользователь из файла", userFromFile.toString());
        Allure.addAttachment("Созданный на сервисе пользователь", userReqres.toString());
        if (!userFromFile.getName().equals(userReqres.getName())) {
            throw new AssertionError("Имя созданного на сервисе пользователя и измененная работа " +
                    "пользователя, созданного из файла, различаются\nИмя пользователя из файла: " + userFromFile.getName() +
                    "\nИмя пользователя из сервиса: " + userReqres.getName());
        }
        if (!userFromFile.getJob().equals(userReqres.getJob())) {
            throw new AssertionError("Работа созданного на сервисе пользователя и измененная работа " +
                    "пользователя, созданного из файла, различаются\nРабота пользователя из файла: " + userFromFile.getJob() +
                    "\nРабота пользователя из сервиса: " + userReqres.getJob());
        }
    }

    @И("отправить запрос на создание данного пользователя на сервисе reqres")
    public void createNewUser() {
        userReqres = reqresApi.createUser(userFromFile)
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .body()
                .as(User.class);
        Allure.addAttachment("Созданный на сервисе пользователь", userReqres.toString());
    }
}
