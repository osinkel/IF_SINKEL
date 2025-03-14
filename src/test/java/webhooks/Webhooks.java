package webhooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ConfigReader;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Webhooks {

    @BeforeEach
    @Step("Открыть браузер")
    public void setup() {
        Configuration.browser = ConfigReader.getProp("selenide.browser");
        Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();
        Configuration.timeout = Long.parseLong(ConfigReader.getProp("selenide.timeout"));

        Selenide.open(ConfigReader.getProp("selenide.url"));
        getWebDriver().manage().window().maximize();
    }

    @BeforeAll
    public static void initializeAllureListener() {
        SelenideLogger.addListener(
                "AllureTestListener",
                new AllureSelenide()
                        .screenshots(Boolean.parseBoolean(ConfigReader.getProp("logger.save.screenshot")))
                        .savePageSource(Boolean.parseBoolean(ConfigReader.getProp("logger.save.page.source"))));
    }

    @AfterEach
    @Step("Закрыть браузер")
    public void afterTest() {
        Selenide.closeWebDriver();
    }

}
