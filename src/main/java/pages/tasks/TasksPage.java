package pages.tasks;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.ProjectPage;

import static com.codeborne.selenide.Selenide.$x;

public class TasksPage extends ProjectPage {
    private SelenideElement bugCounter = $x("//div[@class='showing']").as("Счетчик задач");
    private SelenideElement openCreateBugWindowButton = $x("//a[@id='create_link']").as("Кнопка 'Создать'");
    private SelenideElement filterButton = $x("//button[@id='subnav-trigger']")
            .as("Кнопка для открытия фильтра");
    private SelenideElement reportedByMeFilter = $x("//a[@data-item-id='reportedbyme']")
            .as("Фильтр - Сообщенные мной");
    private SelenideElement firstTaskInList = $x("//ol[@class='issue-list']/li[1]/a")
            .as("Первая задача в списке");
    private SelenideElement inProgressButton = $x("//span[text()='В работе']").as("Кнопка 'В работе'");
    private SelenideElement businessProcessButton = $x("//span[text()='Бизнес-процесс']/..")
            .as("Кнопка 'Бизнес-процесс'");
    private SelenideElement completedButton = $x("//span[text()='Выполнено']").as("Кнопка 'Выполнено'");
    private SelenideElement currentStatus = $x("//span[@id='status-val']/span").as("Текущий статус задачи");

    @Step("Проверить значение счетчика")
    public Integer getBugCounterValue(){
        return Integer.parseInt(this.bugCounter.getText().split(" ")[2]);
    }

    @Step("Нажать на кнопку создания задачи")
    public void openCreateBugWindow() {
        this.openCreateBugWindowButton.click();
    }

    @Step("Перейти в ранее созданную задачу")
    public void goToCreatedTask(){
        changeViewToTasks();
        this.filterButton.click();
        this.reportedByMeFilter.click();
        this.firstTaskInList.click();
    }

    @Step("Установить текущий статус задачи 'В процессе'")
    public void setStatusInProgress(){
        this.inProgressButton.click();
        Selenide.sleep(1000L);
    }

    @Step("Установить текущий статус задачи 'Готово'")
    public void setStatusCompleted(){
        this.businessProcessButton.click();
        this.completedButton.click();
        Selenide.sleep(1000L);
    }

    @Step("Получить текущий статус задачи")
    public String getCurrentStatus(){
        return currentStatus.getOwnText();
    }

}
