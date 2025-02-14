package pages.tasks;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.ProjectPage;

import static com.codeborne.selenide.Selenide.$x;

public class TasksListPage extends ProjectPage {

    private SelenideElement boardName = $x("//span[@id='ghx-board-name']").as("Название доски");

    public String returnBoardName(){
        return this.boardName.shouldBe(Condition.visible).getText();
    }
}
