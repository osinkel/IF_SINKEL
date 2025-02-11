package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private SelenideElement usernameInput = $x("//input[@id='login-form-username']");
    private SelenideElement passwordInput = $x("//input[@id='login-form-password']");
    private SelenideElement loginButton = $x("//input[@id='login']");
    private  SelenideElement welcomeMessage = $x("//div[@class='intro']/h3");

    public void inputUsername(String username) { this.usernameInput.val(username); }

    public void inputPassword(String password) { this.passwordInput.val(password); }

    public void clickLoginButton() { this.loginButton.click(); }

    public String returnWelcomeMessage(){ return welcomeMessage.getText(); }
}
