package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProjectPage extends BasePage {

    private SelenideElement tasksView = $x("//span[@title='Задачи']/../../a").as("Вид 'Задачи'");
    private SelenideElement tasksListView = $x("//span[@title='Список задач']/../../a")
            .as("Вид 'Спиок задач'");

    public void changeViewToTasks(){
        this.tasksView.click();
    }

    public void changeViewToTasksList(){
        this.tasksListView.click();
    }
}
