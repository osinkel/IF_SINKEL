package pages.tasks;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TaskPage {

    private SelenideElement statusDetails = $x("//span[@id='status-val']/span").as("Статус задачи");
    private SelenideElement versionDetails = $x("//span[@id='fixfor-val']/span").as("Исправить в версиях");

    public String getStatusDetailsValue(){
        return this.statusDetails.getOwnText();
    }

    public String getVersionDetailsValue(){
        return this.versionDetails.getText();
    }
}
