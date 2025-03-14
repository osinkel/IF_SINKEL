package pages.tasks;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;

import static com.codeborne.selenide.Selenide.$x;

public class TaskPage {

    private SelenideElement statusDetails = $x("//span[@id='status-val']/span").as("Статус задачи");
    private SelenideElement versionDetails = $x("//span[@id='fixfor-val']/span").as("Исправить в версиях");

    @Step("Сравнить статус и версию для изменения в задаче")
    public void compareStatusAndVersion(String expectedStatus, String expectedVersion) {

        Assertions.assertThat(statusDetails.getOwnText())
                .as("Сравнить статус задачи")
                .isEqualTo(expectedStatus);

        Assertions.assertThat(versionDetails.getText())
                .as("Сравнить версию для изменений задачи")
                .isEqualTo(expectedVersion);
    }
}
