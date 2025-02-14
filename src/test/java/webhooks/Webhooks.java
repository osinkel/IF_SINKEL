package webhooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Webhooks {

    @BeforeEach
    public void setup(){
        Configuration.browser = "chrome";
        Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();
        Configuration.timeout = 70000;

        Selenide.open("https://edujira.ifellow.ru");
        getWebDriver().manage().window().maximize();
    }

    @AfterEach
    public void afterTest() {
        Selenide.closeWebDriver();
    }

}
