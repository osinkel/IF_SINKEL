package steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();
    @Когда("введены имя пользователя пользователя {string}, пароль {string} и нажата кнопка входа")
    public void login(String username, String password){
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();
    }

    @Тогда("тогда выполнен переход на главную страницу и виден элемент Лента активности")
    public void checkWelcomeMessage(){
        System.out.println(loginPage.returnWelcomeMessage() + " - виден");
    }
}
