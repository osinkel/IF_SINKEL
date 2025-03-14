package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.tasks.TasksListPage;
import pages.tasks.TasksPage;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectPage extends BasePage {

    private SelenideElement tasksView = $x("//span[@title='Задачи']/../../a").as("Вид 'Задачи'");
    private SelenideElement tasksListView = $x("//span[@title='Список задач']/../../a")
            .as("Вид 'Спиок задач'");

    @Step("Cменить вид проекта за Задачи")
    public TasksPage changeViewToTasks() {
        tasksView.click();
        return new TasksPage();
    }

    @Step("Cменить вид проекта за Список задач")
    public TasksListPage changeViewToTasksList() {
        tasksListView.click();
        return new TasksListPage();
    }
}
