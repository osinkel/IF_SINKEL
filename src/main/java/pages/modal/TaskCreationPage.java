package pages.modal;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.tasks.TasksPage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class TaskCreationPage {
    private SelenideElement summaryField = $x("//input[@id='summary']").as("Тема");
    private SelenideElement descriptionVisualButton =
            $x("//div[@id='description-wiki-edit']//li[@data-mode='wysiwyg']/button")
                    .as("Кнопка 'Визуальный' для описания");
    private SelenideElement labelsField = $x("//textarea[@id='labels-textarea']").as("Метки");
    private SelenideElement environmentVisualButton =
            $x("//div[@id='environment-wiki-edit']//li[@data-mode='wysiwyg']/button").
                    as("Кнопка 'Визуальный' для окружения");
    private SelenideElement assignToMeButton = $x("//button[@id='assign-to-me-trigger']")
            .as("Кнопка 'Назначить меня' (исполнителем)");
    private SelenideElement createBugButton = $x("//input[@id='create-issue-submit']")
            .as("Кнопка 'Создать'");
    private SelenideElement changeInVersion2 = $x("//select[@id='fixVersions']//option[@value='10001']")
            .as("Селектор исправить в версии");
    private SelenideElement affectedVersion2 = $x("//select[@id='versions']//option[@value='10001']")
            .as("Селектор затронутой версии");
    private SelenideElement issuedLinksButton =
            $x("//div[@id='issuelinks-issues-multi-select']/span[@class='icon noloading drop-menu']")
                    .as("Элемент получения задач для связывания");
    private SelenideElement firstEssuedLink =
            $x("//div[@class='ajs-layer box-shadow active']//*[@id='поиск-по-истории']/*[1]/a")
                    .as("Первая задача для связывания");
    private SelenideElement epicInput = $x("//input[@id='customfield_10100-field']")
            .as("Элемент для получения ссылкок на эпик");
    private SelenideElement firstEpicLink =
            $x("//div[@class='ajs-layer box-shadow active']//*[@id='предложения']/*[1]")
                    .as("Первый эпик");
    private SelenideElement sprintInput = $x("//input[@id='customfield_10104-field']")
            .as("Элемент получения спринтов");
    private SelenideElement firstSprintLink =
            $x("//div[@class='ajs-layer box-shadow active']//*[@id='предложения']/*[1]")
                    .as("Первый спринт");
    private SelenideElement severityMinorField = $x("//select[@id='customfield_10400']/option[2]")
            .as("Серьезность");
    private SelenideElement descriptionFrame = $x("//div[@id='description-wiki-edit']//iframe")
            .as("Фрэйм с описанием");
    private SelenideElement environmentFrame = $x("//div[@id='environment-wiki-edit']//iframe")
            .as("Фрэйм с окружением");
    private SelenideElement commonParagraph = $x("//p").as("Параграф");

    @Step("Нажать на кнопку создания бага")
    public TasksPage createBug() {
        this.createBugButton.click();
        return new TasksPage();
    }

    @Step("Заполнить поле 'Тема'")
    public TaskCreationPage fillSummaryField(String summary) {
        this.summaryField.shouldBe(Condition.visible).val(summary);
        return this;
    }

    @Step("Заполнить поле 'Описание'")
    public TaskCreationPage fillDescriptionField(String description) {
        switchTo().frame(descriptionFrame);
        commonParagraph.val(description);
        switchTo().parentFrame();
        return this;
    }

    @Step("Заполнить поле 'Метки'")
    public TaskCreationPage fillLabelsField(String label) {
        this.labelsField.shouldBe(Condition.visible).val(label);
        return this;
    }

    @Step("Заполнить поле 'Окружение'")
    public TaskCreationPage fillEnvironmentField(String environment) {
        switchTo().frame(environmentFrame);
        commonParagraph.val(environment);
        switchTo().parentFrame();
        return this;
    }

    @Step("Выбрать первую задачу из списка 'Связанные задачи'")
    public TaskCreationPage fillIssuedLinksField() {
        this.issuedLinksButton.click();
        this.firstEssuedLink.click();
        return this;
    }

    @Step("Нажать на кнопку 'Визуальный' у поля 'Описание'")
    public TaskCreationPage clickDescriptionVisualButton() {
        this.descriptionVisualButton.click();
        return this;
    }

    @Step("Нажать на кнопку 'Визуальный' у поля 'Окружение'")
    public TaskCreationPage clickEnvironmentVisualButton() {
        this.environmentVisualButton.click();
        return this;
    }

    @Step("Нажать на кнопку 'Назничить меня'")
    public TaskCreationPage clickAssignToMeButton() {
        this.assignToMeButton.click();
        return this;
    }

    @Step("Выбрать версию для изменений '2.0'")
    public TaskCreationPage setChangeInVersion2() {
        this.changeInVersion2.click();
        return this;
    }

    @Step("Нажать на кнопку 'Визуальный' у поля 'Описание'")
    public TaskCreationPage setAffectedVersion2() {
        this.affectedVersion2.click();
        return this;
    }

    @Step("Выбрать первый эпик из списка доступных эпиков")
    public TaskCreationPage setEpicInput() {
        this.epicInput.click();
        this.firstEpicLink.click();
        return this;
    }

    @Step("Выбрать первый спринт из списка доступных спринтов")
    public TaskCreationPage setSprintInput() {
        this.sprintInput.click();
        this.firstSprintLink.click();
        return this;
    }

    @Step("Выбрать не значительную серьезность задачи")
    public TaskCreationPage setSeverity() {
        this.severityMinorField.click();
        return this;
    }
}
