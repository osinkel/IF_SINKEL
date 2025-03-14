package pagestest;

import config.ConfigReader;
import io.qameta.allure.Description;
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
    @Description("Авторизация пользователя на сайт edujira.ifellow.ru")
    public void loginIfellowTest(){
        loginPage
                .inputUsername(ConfigReader.getProp("username"))
                .inputPassword(ConfigReader.getProp("password"))
                .clickLoginButton()
                .checkWelcomeMessage(ConfigReader.getProp("test.welcome.message"));
    }

    @Test
    @DisplayName("Перейти в проект 'Test'")
    @Description("После авторизации переход в проект 'Test'")
    public void goToTestProjectTest(){
        loginIfellowTest();
        tasksListPage
                .openTestProject()
                .changeViewToTasksList()
                .checkBoardName(ConfigReader.getProp("page.main.board.name"));
    }

    @Test
    @DisplayName("Проверить общее количество заведенных задач в проекте")
    @Description("Создать задачу и проверить или сменился счетчик существующих задач")
    public void checkBugCounterTest(){
        goToTestProjectTest();
        tasksPage
                .changeViewToTasks()
                .getBugCounterValue()
                .openCreateBugWindow()
                .fillSummaryField(ConfigReader.getProp("page.task.summary"))
                .createBug()
                .changeViewToTasks()
                .getBugCounterValue()
                .checkBugCounter();
    }

    @Test
    @DisplayName("Перейти в задачу 'TestSeleniumATHomework' и проверить статус и версию для исправления")
    @Description("С помощью поискового запроса 'TestSeleniumATHomework' перейти в соответствую задачу и" +
            " проверить статус и версию для исправления этой задачи")
    public void checkBugStatusAndVersionTest(){
        checkBugCounterTest();
        tasksPage
                .setSearchQuery(ConfigReader.getProp("page.main.search.query"))
                .openSearchResultItem()
                .compareStatusAndVersion(ConfigReader.getProp("test.status.todo"), ConfigReader.getProp("test.version"));
    }

    @Test
    @DisplayName("Создать новый баг с описанием")
    @Description("Создать полноценную задачу с заполнением всех доступных полей и перевести ее в статусы 'В работе' и 'Готово'")
    public void createNewBugTest(){
//        checkBugStatusAndVersionTest();
        goToTestProjectTest();
        tasksPage
                .changeViewToTasks()
                .getBugCounterValue()
                .openCreateBugWindow()
                .fillSummaryField(ConfigReader.getProp("page.task.summary"))
                .fillDescriptionField(ConfigReader.getProp("page.task.description"))
                .clickDescriptionVisualButton()
                .fillLabelsField(ConfigReader.getProp("page.task.label"))
                .fillEnvironmentField(ConfigReader.getProp("page.task.environment"))
                .clickEnvironmentVisualButton()
                .fillIssuedLinksField()
                .clickAssignToMeButton()
                .setChangeInVersion2()
                .setAffectedVersion2()
                .setEpicInput()
                .setSprintInput()
                .setSeverity()
                .createBug()
                .changeViewToTasks()
                .getBugCounterValue()
                .checkBugCounter()
                .goToCreatedTask()
                .setStatusInProgress()
                .setStatusCompleted()
                .checkCurrentTaskStatus(ConfigReader.getProp("test.status.complete"));
    }

}
