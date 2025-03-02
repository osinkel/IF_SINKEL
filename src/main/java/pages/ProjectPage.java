package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectPage extends BasePage {

    private SelenideElement tasksView = $x("//span[@title='Задачи']/../../a").as("Вид 'Задачи'");
    private SelenideElement tasksListView = $x("//span[@title='Список задач']/../../a")
            .as("Вид 'Спиок задач'");

    @Step("Cменить вид проекта за Задачи")
    public void changeViewToTasks(){
        this.tasksView.click();
    }

    @Step("Cменить вид проекта за Список задач")
    public void changeViewToTasksList(){
        this.tasksListView.click();
    }
}
