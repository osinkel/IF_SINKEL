package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BasePage {

    private SelenideElement projectsMenu = $x("//div[@class='aui-header-primary']//ul[@class='aui-nav']/li[2]");
    private SelenideElement testProjectLink = $x("//a[@id='admin_main_proj_link_lnk']");
    private SelenideElement searchInput = $x("//input[@id='quickSearchInput']");
    private SelenideElement searchResultItem = $x("//div[@class='quicksearch-dropdown']/div[1]/ul/li[1]");

    public void openTestProject(){
        this.projectsMenu.click();
        this.testProjectLink.shouldBe(Condition.visible).click();
    }

    public void setSearchQuery(String query){
        this.searchInput.val(query);
    }

    public void openSearchResultItem(){
        searchResultItem.shouldBe(Condition.visible).click();
    }
}
