package pages.tasks;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.ProjectPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class TasksPage extends ProjectPage {
    private SelenideElement bugCounter = $x("//div[@class='showing']");
    private SelenideElement openCreateBugWindowButton = $x("//a[@id='create_link']");
    private SelenideElement filterButton = $x("//button[@id='subnav-trigger']");
    private SelenideElement reportedByMeFilter = $x("//a[@data-item-id='reportedbyme']");
    private SelenideElement firstTaskInList = $x("//ol[@class='issue-list']/li[1]/a");
    private SelenideElement inProgressButton = $x("//span[text()='В работе']");
    private SelenideElement businessProcessButton = $x("//span[text()='Бизнес-процесс']/..");
    private SelenideElement completedButton = $x("//span[text()='Выполнено']");
    private SelenideElement currentStatus = $x("//span[@id='status-val']/span");

    public Integer getBugCounterValue(){
        return Integer.parseInt(this.bugCounter.getText().split(" ")[2]);
    }

    public void openCreateBugWindow() {
        this.openCreateBugWindowButton.click();
    }

    public void goToCreatedTask(){
        changeViewToTasks();
        this.filterButton.click();
        this.reportedByMeFilter.click();
        this.firstTaskInList.click();
    }

    public void setStatusInProgress(){
        this.inProgressButton.click();
        Selenide.sleep(1000);
    }

    public void setStatusCompleted(){
        this.businessProcessButton.shouldBe().click();
        this.completedButton.click();
        Selenide.sleep(1000);
    }

    public String getCurrentStatus(){
        return currentStatus.getOwnText();
    }

}
