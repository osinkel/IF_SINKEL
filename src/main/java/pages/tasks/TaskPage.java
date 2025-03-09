package pages.tasks;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class TaskPage {

    private SelenideElement statusDetails = $x("//span[@id='status-val']/span").as("Статус задачи");
    private SelenideElement versionDetails = $x("//span[@id='fixfor-val']/span").as("Исправить в версиях");

    @Step("Получить текущий статус задачи")
    public String getStatusDetailsValue(){
        return this.statusDetails.getOwnText();
    }

    @Step("Получить текущую версию для изменения")
    public String getVersionDetailsValue(){
        return this.versionDetails.getText();
    }
}
