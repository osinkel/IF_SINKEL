package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class BasePage {

    private SelenideElement projectsMenu = $x("//div[@class='aui-header-primary']//ul[@class='aui-nav']/li[2]")
            .as("Кнопка 'Проекты'");
    private SelenideElement testProjectLink = $x("//a[@id='admin_main_proj_link_lnk']")
            .as("Проект 'Test(TEST)'");
    private SelenideElement searchInput = $x("//input[@id='quickSearchInput']").as("Поисковая строка");
    private SelenideElement searchResultItem = $x("//div[@class='quicksearch-dropdown']/div[1]/ul/li[1]")
            .as("Выпадающий список с результатами поиска");

    @Step("Открыть проект 'TEST'")
    public void openTestProject(){
        this.projectsMenu.click();
        this.testProjectLink.shouldBe(Condition.visible).click();
    }

    @Step("Ввести поисковой запрос в строку поиска")
    public void setSearchQuery(String query){
        this.searchInput.val(query);
    }

    @Step("Выбрать первый результат поиска")
    public void openSearchResultItem(){
        searchResultItem.shouldBe(Condition.visible).click();
    }
}
