package steps;

import io.cucumber.java.ru.Если;
import pages.ProjectPage;

public class ProjectSteps {
    ProjectPage projectPage = new ProjectPage();

    @Если("перейти на вид Задачи")
    public void changeViewToTasks(){
        projectPage.changeViewToTasks();
    }
}
