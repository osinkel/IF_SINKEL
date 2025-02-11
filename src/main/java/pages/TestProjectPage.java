package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.refresh;

public class TestProjectPage {
    private SelenideElement bugCounter = $x("//div[@class='showing']");
    private SelenideElement openCreateBugWindowButton = $x("//a[@id='create_link']");
    private SelenideElement createBugButton = $x("//input[@id='create-issue-submit']");
    private SelenideElement searchInput = $x("//input[@id='quickSearchInput']");
    private SelenideElement searchResultItem = $x("//div[@class='quicksearch-dropdown']/div[1]/ul/li[1]");
    private SelenideElement summaryField = $x("//input[@id='summary']");
    private SelenideElement descriptionField = $x("//*[@id='tinymce']//p");
    private SelenideElement descriptionVisualButton = $x("//div[@id='description-wiki-edit']//li[@data-mode='wysiwyg']/button");
    private SelenideElement labelsField = $x("//textarea[@id='labels-textarea']");
    private SelenideElement environmentField = $x("//textarea[@id='environment']");
    private SelenideElement environmentVisualButton = $x("//div[@id='environment-wiki-edit']//li[@data-mode='wysiwyg']/button");
    private SelenideElement issuedLinksField = $x("//textarea[@id='issuelinks-issues-textarea']");
    private SelenideElement assignToMeButton = $x("//button[@id='assign-to-me-trigger']");
    private SelenideElement epicInput = $x("//input[@id='customfield_10100-field']");
    private SelenideElement epicLink = $x("//*contains(text(), 'TEST-')[1]");
    private SelenideElement createdTaskLink = $x("//div[@class='ghx-backlog-group']/div/div[2]/div[2]//a");
    private SelenideElement tasksInListView = $x("//span[@title='Список задач']/../../a");
    private SelenideElement tasksView = $x("//span[@title='Задачи']/../../a");


    public Integer getBugCounterValue(){
        return Integer.parseInt(this.bugCounter.getText().split(" ")[2]);
    }

    public void openCreateBugWindow() {
        this.openCreateBugWindowButton.click();
        Selenide.sleep(1000);
    }

    public void createBug() {
        this.createBugButton.click();
        refresh();
    }

    public void setSearchQuery(String query){
        this.searchInput.val(query);
    }

    public void openSearchResultItem(){
        searchResultItem.shouldBe(Condition.visible).click();
    }

    public void fillSummaryField(String summary){
        this.summaryField.shouldBe(Condition.visible).val(summary);
    }

    public void fillDescriptionField(String desription){
        this.descriptionField.val(desription);
    }

    public void fillLabelsField(String label){
        this.labelsField.shouldBe(Condition.visible).val(label);
    }

    public void fillEnvironmentField(String environment){
        this.environmentField.shouldBe(Condition.visible).val(environment);
    }

    public void fillIssuedLinksField(String issue){
        this.issuedLinksField.shouldBe(Condition.visible).val(issue);
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

    public void setEpicInput(){
        this.epicInput.click();
        this.epicLink.shouldBe(Condition.visible).click();
//        ajs-layer box-shadow active
    }

    public void goToCreatedTask(){
        this.tasksInListView.click();
        this.createdTaskLink.shouldBe(Condition.visible).click();
    }

    public void changeViewToTasks(){
        this.tasksView.click();
    }

}
