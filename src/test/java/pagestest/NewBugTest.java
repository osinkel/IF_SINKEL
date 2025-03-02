package pagestest;

import config.ConfigReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.modal.TaskCreationPage;
import pages.tasks.TaskPage;
import pages.tasks.TasksListPage;
import pages.tasks.TasksPage;
import webhooks.Webhooks;

@DisplayName("Тест создания бага")
public class NewBugTest extends Webhooks {
    private final LoginPage loginPage = new LoginPage();
    private final TasksListPage tasksListPage = new TasksListPage();
    private final TasksPage tasksPage = new TasksPage();
    private final TaskPage taskPage = new TaskPage();
    private final TaskCreationPage taskCreationPage = new TaskCreationPage();

    @Test
    @DisplayName("Вход в edujira.ifellow.ru")
    public void loginIfellowTest(){
        loginPage.inputUsername(ConfigReader.getProp("username"));
        loginPage.inputPassword(ConfigReader.getProp("password"));
        loginPage.clickLoginButton();
        Assertions.assertEquals(ConfigReader.getProp("test.welcomemessage"), loginPage.returnWelcomeMessage());
    }

    @Test
    @DisplayName("Перейти в проект 'Test'")
    public void goToTestProjectTest(){
        loginIfellowTest();
        tasksListPage.openTestProject();
        tasksListPage.changeViewToTasksList();
        Assertions.assertEquals(ConfigReader.getProp("page.main.boaardname"), tasksListPage.returnBoardName());
    }

    @Test
    @DisplayName("Проверить общее количество заведенных задач в проекте")
    public void checkBugCounterTest(){
        goToTestProjectTest();
        tasksPage.changeViewToTasks();
        Integer initialCounterValue = tasksPage.getBugCounterValue();
        tasksPage.openCreateBugWindow();
        taskCreationPage.fillSummaryField(ConfigReader.getProp("page.task.summary"));
        taskCreationPage.createBug();
        tasksPage.changeViewToTasks();
        Integer finalCounterValue = tasksPage.getBugCounterValue();
        Assertions.assertEquals(1, finalCounterValue-initialCounterValue);
    }

    @Test
    @DisplayName("Перейти в задачу TestSeleniumATHomework и проверить статус и версию для исправления")
    public void checkBugStatusAndVersionTest(){
        checkBugCounterTest();
        tasksPage.setSearchQuery(ConfigReader.getProp("page.main.searchquery"));
        tasksPage.openSearchResultItem();
        Assertions.assertEquals(ConfigReader.getProp("test.status.todo"), taskPage.getStatusDetailsValue());
        Assertions.assertEquals(ConfigReader.getProp("test.version"), taskPage.getVersionDetailsValue());
    }

    @Test
    @DisplayName("Создать новый баг с описанием")
    public void createNewBugTest(){
        checkBugStatusAndVersionTest();
        tasksPage.changeViewToTasks();
        Integer initialCounterValue = tasksPage.getBugCounterValue();
        tasksPage.openCreateBugWindow();
        taskCreationPage.fillSummaryField(ConfigReader.getProp("page.task.summary"));
        taskCreationPage.fillDescriptionField(ConfigReader.getProp("page.task.description"));
        taskCreationPage.clickDescriptionVisualButton();
        taskCreationPage.fillLabelsField(ConfigReader.getProp("page.task.label"));
        taskCreationPage.fillEnvironmentField(ConfigReader.getProp("page.task.environment"));
        taskCreationPage.clickEnvironmentVisualButton();
        taskCreationPage.fillIssuedLinksField();
        taskCreationPage.clickAssignToMeButton();
        taskCreationPage.setChangeInVersion2();
        taskCreationPage.setAffectedVersion2();
        taskCreationPage.setEpicInput();
        taskCreationPage.setSprintInput();
        taskCreationPage.setSeverity();
        taskCreationPage.createBug();
        tasksPage.changeViewToTasks();
        Integer finalCounterValue = tasksPage.getBugCounterValue();
        Assertions.assertEquals(1, finalCounterValue-initialCounterValue);
        tasksPage.goToCreatedTask();
        tasksPage.setStatusInProgress();
        tasksPage.setStatusCompleted();
        Assertions.assertEquals(ConfigReader.getProp("test.status.complete"), tasksPage.getCurrentStatus());
    }

}
