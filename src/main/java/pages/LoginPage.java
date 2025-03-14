package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private SelenideElement usernameInput = $x("//input[@id='login-form-username']").as("Имя пользователя");
    private SelenideElement passwordInput = $x("//input[@id='login-form-password']").as("Пароль");
    private SelenideElement loginButton = $x("//input[@id='login']").as("Кнопка авторизации");
    private SelenideElement welcomeMessage = $x("//h3[text()='Лента активности']")
            .as("Текст подтверждающий успешный вход");

    @Step("Ввести имя пользователя")
    public LoginPage inputUsername(String username) {
        usernameInput.val(username);
        return this;
    }

    @Step("Ввести пароль")
    public LoginPage inputPassword(String password) {
        passwordInput.val(password);
        return this;
    }

    @Step("Нажать на кнопку 'Войти'")
    public LoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }

    @Step("Проверить наличие приветственного сообщения")
    public void checkWelcomeMessage(String expectedText) {
        Assertions.assertThat(welcomeMessage.getText())
                .as("Проверить наличие приветственного сообщения")
                .isEqualTo(expectedText);
    }
}
