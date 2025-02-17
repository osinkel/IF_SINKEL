package pages.tasks;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.ProjectPage;

import static com.codeborne.selenide.Selenide.*;

public class TasksPage extends ProjectPage {
    private SelenideElement bugCounter = $x("//div[@class='showing']").as("Счетчик задач");
    private SelenideElement filterButton = $x("//button[@id='subnav-trigger']")
            .as("Кнопка для открытия фильтра");
    private SelenideElement reportedByMeFilter = $x("//a[@data-item-id='reportedbyme']")
            .as("Фильтр - Сообщенные мной");
    private SelenideElement firstTaskInList = $x("//ol[@class='issue-list']/li[1]/a")
            .as("Первая задача в списке");
    private SelenideElement inProgressButton = $x("//span[text()='В работе']").as("Кнопка 'В работе'");
    private SelenideElement businessProcessButton = $x("//span[text()='Бизнес-процесс']")
            .as("Кнопка 'Бизнес-процесс'");
    private SelenideElement completedButton = $x("//span[text()='Выполнено']").as("Кнопка 'Выполнено'");
    private SelenideElement currentStatus = $x("//span[@id='status-val']/span").as("Текущий статус задачи");

    public Integer getBugCounterValue(){
        return Integer.parseInt(this.bugCounter.getText().split(" ")[2]);
    }

    public void goToCreatedTask(){
        this.changeViewToTasks();
        this.filterButton.click();
        this.reportedByMeFilter.click();
        this.firstTaskInList.click();
    }

    public void setStatusInProgress(){
        this.inProgressButton.click();
        Selenide.sleep(1000L);
    }

    public void setStatusCompleted(){
        this.businessProcessButton.click();
        this.completedButton.click();
        Selenide.sleep(1000L);
    }

    public String getCurrentStatus(){
        return currentStatus.getOwnText();
    }

}
