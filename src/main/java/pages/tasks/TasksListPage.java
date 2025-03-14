package pages.tasks;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import pages.ProjectPage;

import static com.codeborne.selenide.Selenide.$x;

public class TasksListPage extends ProjectPage {

    private SelenideElement boardName = $x("//span[@id='ghx-board-name']").as("Название доски");

    @Step("Проверить название проекта")
    public void checkBoardName(String expectedText) {
        Assertions.assertThat(boardName.shouldBe(Condition.visible).getText())
                .as("Проверить название проекта")
                .isEqualTo(expectedText);
    }
}
