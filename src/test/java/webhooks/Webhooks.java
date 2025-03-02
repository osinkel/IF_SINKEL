package webhooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.ConfigReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Webhooks {

    @BeforeEach
    public void setup(){
        Configuration.browser = ConfigReader.getProp("browser");
        Configuration.pageLoadStrategy = PageLoadStrategy.EAGER.toString();
        Configuration.timeout = 10000;

        Selenide.open(ConfigReader.getProp("url"));
        getWebDriver().manage().window().maximize();
    }

    @AfterEach
    public void afterTest() {
        Selenide.closeWebDriver();
    }

}
