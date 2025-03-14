package pages.tasks;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import pages.ProjectPage;
import pages.modal.TaskCreationPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class TasksPage extends ProjectPage {

    static int initialCounterValue;
    static int finalCounterValue;
    static boolean isInitialCounter = true;

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
    public TasksPage getBugCounterValue() {
        if (isInitialCounter) {
            initialCounterValue = Integer.parseInt(this.bugCounter.getText().split(" ")[2]);
        } else {
            finalCounterValue = Integer.parseInt(this.bugCounter.getText().split(" ")[2]);
        }
        isInitialCounter = !isInitialCounter;
        return this;
    }

    @Step("Провериь увеличился ли счетчик общего количества задач на 1")
    public TasksPage checkBugCounter() {
        Assertions.assertThat(finalCounterValue - initialCounterValue == 1)
                .as("Проверка увеличения счетчика на 1")
                .isTrue();
        return this;
    }

    @Step("Сравнить текущий статус задачи")
    public void checkCurrentTaskStatus(String expectedStatus) {
        Assertions.assertThat(currentStatus
                        .should(Condition.exactOwnText(expectedStatus), Duration.ofSeconds(1)).getOwnText())
                .as("Сравнить текущий статус задачи")
                .isEqualTo(expectedStatus);
    }

    @Step("Нажать на кнопку создания задачи")
    public TaskCreationPage openCreateBugWindow() {
        this.openCreateBugWindowButton.click();
        return new TaskCreationPage();
    }

    @Step("Перейти в ранее созданную задачу")
    public TasksPage goToCreatedTask() {
        changeViewToTasks();
        filterButton.click();
        reportedByMeFilter.click();
        firstTaskInList.click();
        return this;
    }

    @Step("Установить текущий статус задачи 'В процессе'")
    public TasksPage setStatusInProgress() {
        this.inProgressButton.click();
        Selenide.sleep(1000L);
        return this;
    }

    @Step("Установить текущий статус задачи 'Готово'")
    public TasksPage setStatusCompleted() {
        businessProcessButton.click();
        completedButton.click();
        return this;
    }
}
