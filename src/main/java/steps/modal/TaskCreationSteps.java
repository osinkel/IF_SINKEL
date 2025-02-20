package steps.modal;

import io.cucumber.java.ru.И;
import pages.modal.TaskCreationPage;

public class TaskCreationSteps {

    TaskCreationPage taskCreationPage = new TaskCreationPage();

    @И("в открывшемся модальном окне заполнить поле Тема значением {string}")
    public void fillSummaryField(String summary){
        taskCreationPage.fillSummaryField(summary);
    }

    @И("нажать на кнопку Создать")
    public void clickCreateButton(){
        taskCreationPage.createBug();
    }

    @И("заполнить поле Описание значением {string}")
    public void fillDescriptionField(String value){
        taskCreationPage.fillDescriptionField("HW3_IF_SINKEL");
    }

    @И("нажать кнопку Визуальный у поля Описание")
    public void clickDescriptionVisualButton(){
        taskCreationPage.clickDescriptionVisualButton();
    }

    @И("заполнить поле метки значением {string}")
    public void fillLabelsField(String value){
        taskCreationPage.fillLabelsField(value);
    }

    @И("заполнить поле Окружение значением {string}")
    public void fillEnvironmentField(String value){
        taskCreationPage.fillEnvironmentField(value);
    }

    @И("нажать кнопку Визуальный у поля Окружение")
    public void clickEnvironmentVisualButton(){
        taskCreationPage.clickEnvironmentVisualButton();
    }

    @И("заполнить поле Задача")
    public void fillIssuedLinksField(){
        taskCreationPage.fillIssuedLinksField();
    }

    @И("нажать на кнопку Назанчить меня")
    public void fillLabelsField(){
        taskCreationPage.clickAssignToMeButton();
    }

    @И("выбрать значение для поля Изменить в версиях - 2.0")
    public void setChangeInVersion2(){
        taskCreationPage.setChangeInVersion2();
    }

    @И("выбрать значение для поля Затронуты версии - 2.0")
    public void setAffectedVersion2(){
        taskCreationPage.setAffectedVersion2();
    }

    @И("выбрать ссылку на эпик")
    public void setEpicInput(){
        taskCreationPage.setEpicInput();
    }

    @И("выбрать спринт")
    public void setSprintInput(){
        taskCreationPage.setSprintInput();
    }

    @И("выбрать серьезность")
    public void setSeverity(){
        taskCreationPage.setSeverity();
    }

}
