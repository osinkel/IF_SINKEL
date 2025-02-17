package steps.tasks;

import io.cucumber.java.ru.Тогда;
import pages.tasks.TaskPage;
import pages.tasks.TasksPage;

public class TaskSteps {

    TaskPage taskPage = new TaskPage();

    @Тогда("проверить поля статуса и версии для изменения этой задачи")
    public void checkTaskStatusAndVersion(){
        System.out.println("Статус задачи - " + taskPage.getStatusDetailsValue());
        System.out.println("Исправить в версиях - " + taskPage.getVersionDetailsValue());
    }
}
