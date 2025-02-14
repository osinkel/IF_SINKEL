package pages.modal;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

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
    private SelenideElement severityMinorField = $x("//select[@id='customfield_10400']/option[2]").as("Серьезность");

    public void createBug() {
        this.createBugButton.click();
        Selenide.sleep(1000L);
    }

    public void fillSummaryField(String summary){
        this.summaryField.shouldBe(Condition.visible).val(summary);
    }

    public void fillDescriptionField(String description){
        switchTo().frame($x("//div[@id='description-wiki-edit']//iframe"));
        $x("//p").val(description);
        switchTo().parentFrame();
    }

    public void fillLabelsField(String label){
        this.labelsField.shouldBe(Condition.visible).val(label);
    }

    public void fillEnvironmentField(String environment){
        switchTo().frame($x("//div[@id='environment-wiki-edit']//iframe"));
        $x("//p").val(environment);
        switchTo().parentFrame();
    }

    public void fillIssuedLinksField(){
        this.issuedLinksButton.click();
        this.firstEssuedLink.click();
    }

    public void clickDescriptionVisualButton(){
        this.descriptionVisualButton.click();
    }

    public void clickEnvironmentVisualButton(){
        this.environmentVisualButton.click();
    }

    public void clickAssignToMeButton(){
        this.assignToMeButton.click();
    }

    public void setChangeInVersion2() {
        this.changeInVersion2.click();
    }

    public void setAffectedVersion2() {
        this.affectedVersion2.click();
    }

    public void setEpicInput(){
        this.epicInput.click();
        this.firstEpicLink.click();
    }

    public void setSprintInput(){
        this.sprintInput.click();
        this.firstSprintLink.click();
    }

    public void setSeverity(){
        this.severityMinorField.click();
    }
}
