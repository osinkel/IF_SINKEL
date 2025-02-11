import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.*;
import pages.modal.TaskCreationPage;
import pages.tasks.TaskPage;
import pages.tasks.TasksListPage;
import pages.tasks.TasksPage;

public class NewBugTest extends Webhooks {
    private final LoginPage loginPage = new LoginPage();
    private final TasksListPage tasksListPage = new TasksListPage();
    private final TasksPage tasksPage = new TasksPage();
    private final TaskPage taskPage = new TaskPage();
    private final TaskCreationPage taskCreationPage = new TaskCreationPage();

    @Test
    @DisplayName("Вход в edujira.ifellow.ru")
    public void loginIfellowTest(){
        loginPage.inputUsername("AT12");
        loginPage.inputPassword("Qwerty123");
        loginPage.clickLoginButton();
        Assertions.assertEquals("Добро пожаловать в Jira", loginPage.returnWelcomeMessage());
    }

    @Test
    @DisplayName("Перейти в проект 'Test'")
    public void goToTestProjectTest(){
        loginIfellowTest();
        tasksListPage.openTestProject();
        tasksListPage.changeViewToTasksList();
        Assertions.assertEquals("Доска TEST", tasksListPage.returnBoardName());
    }

    @Test
    @DisplayName("Проверить общее количество заведенных задач в проекте")
    public void checkBugCounterTest(){
        goToTestProjectTest();
        tasksPage.changeViewToTasks();
        Integer initialCounterValue = tasksPage.getBugCounterValue();
        tasksPage.openCreateBugWindow();
        taskCreationPage.fillSummaryField("Проверка счетчика");
        taskCreationPage.createBug(true);
        Integer finalCounterValue = tasksPage.getBugCounterValue();
        Assertions.assertEquals(1, finalCounterValue-initialCounterValue);
    }

    @Test
    @DisplayName("Перейти в задачу TestSeleniumATHomework и проверить статус и версию для исправления")
    public void checkBugStatusAndVersionTest(){
        checkBugCounterTest();
        tasksPage.setSearchQuery("TestSeleniumATHomework");
        tasksPage.openSearchResultItem();
        Assertions.assertEquals("Сделать", taskPage.getStatusDetailsValue());
        Assertions.assertEquals("Version 2.0", taskPage.getVersionDetailsValue());
    }

    @Test
    @DisplayName("Создать новый баг с описанием")
    public void createNewBugTest(){
        checkBugStatusAndVersionTest();
        tasksPage.changeViewToTasks();
        Integer initialCounterValue = tasksPage.getBugCounterValue();
        tasksPage.openCreateBugWindow();
        taskCreationPage.fillSummaryField("HW3_IF_SINKEL");
        taskCreationPage.fillDescriptionField("HW3_IF_SINKEL");
        taskCreationPage.clickDescriptionVisualButton();
        taskCreationPage.fillLabelsField("positive");
        taskCreationPage.fillEnvironmentField("HW3_IF_SINKEL");
        taskCreationPage.clickEnvironmentVisualButton();
        taskCreationPage.fillIssuedLinksField();
        taskCreationPage.clickAssignToMeButton();
        taskCreationPage.setChangeInVersion2();
        taskCreationPage.setAffectedVersion2();
        taskCreationPage.setEpicInput();
        taskCreationPage.setSprintInput();
        taskCreationPage.setSeverity();
        taskCreationPage.createBug(true);
        Integer finalCounterValue = tasksPage.getBugCounterValue();
        Assertions.assertEquals(1, finalCounterValue-initialCounterValue);
        tasksPage.goToCreatedTask();
        tasksPage.setStatusInProgress();
        tasksPage.setStatusCompleted();
        Assertions.assertEquals("Готово", tasksPage.getCurrentStatus());
    }

}
