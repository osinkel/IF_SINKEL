package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private SelenideElement projectsMenu = $x("//div[@class='aui-header-primary']//ul[@class='aui-nav']/li[2]");
    private SelenideElement testProjectLink = $x("//a[@id='admin_main_proj_link_lnk']");
//    private SelenideElement projectName = $x("//div[@class='aui-item project-title']/a");
    private SelenideElement boardName = $x("//span[@id='ghx-board-name']");

    public void openTestProject(){
        projectsMenu.click();
        testProjectLink.shouldBe(Condition.visible).click();
    }

    public String returnBoardName(){
        return this.boardName.shouldBe(Condition.visible).getText();
    }
}
