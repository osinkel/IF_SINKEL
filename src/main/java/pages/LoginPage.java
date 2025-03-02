package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private SelenideElement usernameInput = $x("//input[@id='login-form-username']").as("Имя пользователя");
    private SelenideElement passwordInput = $x("//input[@id='login-form-password']").as("Пароль");
    private SelenideElement loginButton = $x("//input[@id='login']").as("Кнопка авторизации");
    private SelenideElement welcomeMessage = $x("//h3[text()='Лента активности']")
            .as("Текст подтверждающий успешный вход");

    @Step("Ввести имя пользователя")
    public void inputUsername(String username) { this.usernameInput.val(username); }

    @Step("Ввести пароль")
    public void inputPassword(String password) { this.passwordInput.val(password); }

    @Step("Нажать на кнопку 'Войти'")
    public void clickLoginButton() { this.loginButton.click(); }

    @Step("Проверить наличие приветственного сообщения")
    public String returnWelcomeMessage(){ return welcomeMessage.getText(); }
}
