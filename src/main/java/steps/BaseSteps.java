package steps;

import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.И;
import pages.BasePage;

public class BaseSteps {

    BasePage basePage = new BasePage();

    @И("нажать на кнопку Создать в горизонтальном навигационном меню")
    public void clickButtonCreateInNavMenu(){
        basePage.openCreateBugWindow();
    }

    @Если("в строке поиска написать имя задачи {string}")
    public void setSeartchQuery(String query){
        basePage.setSearchQuery(query);
    }

    @И("в выпавшем списке выбарать первый результат поиска")
    public void openSearchResultItem(){
        basePage.openSearchResultItem();
    }

}
