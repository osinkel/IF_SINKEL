package steps.tasks;

import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import pages.tasks.TasksPage;

public class TasksSteps {
    Integer initialTaskCounter;
    Integer afterTaskCounter;
    TasksPage tasksPage = new TasksPage();

    @И("запомнить количество текущих задач")
    public void getBugCounterValue(){
        if(this.initialTaskCounter == null){
            this.initialTaskCounter = tasksPage.getBugCounterValue();
        } else {
            this.afterTaskCounter = tasksPage.getBugCounterValue();
        }
    }

    @Тогда("проверить что счетчик задач увеличен на 1")
    public void checkTaskCounterDiff(){
        if(this.afterTaskCounter - this.initialTaskCounter >= 1){
            System.out.println("Счетчик успешно изменился");
        } else {
            System.out.println("Счетчик не изменился");
        }
    }

    @Если("перейти на последнюю созданную задачу")
    public void goToCreatedTask() {
        tasksPage.goToCreatedTask();
    }

    @И("нажать на кнопку В работе")
    public void setStatusInProgress(){
        tasksPage.setStatusInProgress();
    }

    @И("нажать на кнопку Бизнесс-процесс и в выпавшем списке нажать на кнопку Выполнено")
    public void setStatusCompleted(){
        tasksPage.setStatusCompleted();
    }

    @И("проверить текущий статус")
    public void getCurrentStatus(){
        System.out.println("Текущий статус задачи - " + tasksPage.getCurrentStatus());
    }

}
