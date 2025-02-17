package steps.tasks;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import pages.tasks.TasksListPage;

public class TasksListSteps {

    TasksListPage tasksListPage = new TasksListPage();

    @Когда("нажать на кнопку проекты в горизонтальном навигационном меню в выпавшем списке нажать на кнопку с проектом Test \\(TEST)")
    public void clickedOnButtonProjects() {
        tasksListPage.openTestProject();
    }

    @Тогда("выполнен переход на страницу с проектом тест")
    public void checkProjectName() {
        tasksListPage.changeViewToTasksList();
        System.out.println("Выполнен переход на " + tasksListPage.returnBoardName());
    }
}
