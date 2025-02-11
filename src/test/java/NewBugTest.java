import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BugPage;
import pages.LoginPage;
import pages.MainPage;
import pages.TestProjectPage;

public class NewBugTest extends Webhooks {
    private final LoginPage loginPage = new LoginPage();
    private final MainPage mainPage = new MainPage();
    private final TestProjectPage testProjectPage = new TestProjectPage();
    private final BugPage bugPage = new BugPage();

    @Test
    @DisplayName("Вход в edujira.ifellow.ru")
    public void loginIfellow(){
        loginPage.inputUsername("AT12");
        loginPage.inputPassword("Qwerty123");
        loginPage.clickLoginButton();
        Assertions.assertEquals("Добро пожаловать в Jira", loginPage.returnWelcomeMessage());
    }

    @Test
    @DisplayName("Перейти в проект 'Test'")
    public void goToTestProject(){
        loginIfellow();
        mainPage.openTestProject();
        Assertions.assertEquals("Доска TEST", mainPage.returnBoardName());
    }

    @Test
    @DisplayName("Проверить общее количество заведенных задач в проекте")
    public void checkBugCounter(){
        goToTestProject();
        testProjectPage.changeViewToTasks();
        Integer initialCounterValue = testProjectPage.getBugCounterValue();
        testProjectPage.openCreateBugWindow();
        testProjectPage.fillSummaryField("Проверка счетчика");
        testProjectPage.createBug();
        Integer finalCounterValue = testProjectPage.getBugCounterValue();
        Assertions.assertEquals(1, finalCounterValue-initialCounterValue);
    }

    @Test
    @DisplayName("Перейти в задачу TestSeleniumATHomework и проверить статус и версию для исправления")
    public void checkBugStatusAndVersion(){
        checkBugCounter();
        testProjectPage.setSearchQuery("TestSeleniumATHomework");
        testProjectPage.openSearchResultItem();
        Assertions.assertEquals("Сделать", bugPage.getStatusDetailsValue());
        Assertions.assertEquals("Version 2.0", bugPage.getVersionDetailsValue());
    }

    @Test
    @DisplayName("Создать новый баг с описанием")
    public void createNewBug(){
        checkBugStatusAndVersion();
//        testProjectPage.openCreateBugWindow();
//        testProjectPage.fillSummaryField("HW3_IF_SINKEL");
//        testProjectPage.fillDescriptionField("HW3_IF_SINKEL");
//        testProjectPage.clickDescriptionVisualButton();
//        testProjectPage.fillLabelsField("positive");
//        testProjectPage.fillEnvironmentField("HW3_IF_SINKEL");
//        testProjectPage.clickEnvironmentVisualButton();
//        testProjectPage.fillIssuedLinksField("TEST-172051");
//        testProjectPage.clickAssignToMeButton();
//        testProjectPage.setEpicInput();
//        testProjectPage.createBug();
        testProjectPage.goToCreatedTask();
    }

}
