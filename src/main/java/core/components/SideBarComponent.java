package core.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SideBarComponent {

    // Локаторы боковой панели
    private SelenideElement
            logo = $("[data-nimg='1']"),
            nameAndRole = $(".MuiBox-root.css-1ruco7w"),
            chapterOrder = $("[data-button='заявки']"),
            chapterDocs = $("[data-button='документы']"),
            chapterCto = $("[data-button='цто']"),
            chapterClients = $("[data-button='клиенты']"),
            chapterUsers = $("[data-button='пользователи']"),
            chapterDirectory = $("[data-button='справочник']"),
            chapterPricelists = $("[data-button='прайслисты']"),
            chapterDevices = $("[data-button='устройства']"),
            chapterProduction = $("[data-button='производство']"),
            chapterNotifications = $("[data-button='уведомления']"),
            chapterSettings = $("[data-button='настройки']"),
            chapterInstructions = $("[data-button='инструкции']"),
            chapterReports = $("[data-button='отчеты']"),
            chapterContacts = $("[data-button='контакты']"),
            exit = $("[data-button='выход']"),
            closeMenuButton = $("[data-testid='MenuOpenIcon']");


    @Step("Проверяем Логин и Роль")
    public SideBarComponent checkLoginAndRole(String username, String role) {
        nameAndRole.shouldBe(visible)
                .shouldHave(Condition.text(role))
                .shouldHave(Condition.text(username));

        return this;
    }

    @Step("Кликаем на раздел Клиенты")
    public SideBarComponent clickClientsChapter() {
        chapterClients.shouldBe(visible).click();

        return this;
    }

    @Step("Кликаем на раздел Отчеты")
    public SideBarComponent clickReportsChapter() {
        chapterReports.shouldBe(visible).click();

        return this;
    }

    @Step("Кликаем на кнопку Выйти")
    public SideBarComponent exit() {
        exit.shouldBe(visible).click();

        return this;
    }
}
