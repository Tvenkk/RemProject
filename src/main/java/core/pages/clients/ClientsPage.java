package core.pages.clients;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ClientsPage {
    private final String
            TITLE_TEXT = "Таблица клиентов";

    private SelenideElement
            paginationButton = $("[data-testid='pagination-rows']"),
            upButton = $(".css-gbngva"),
            tableHeader = $(".css-1anx036");


    @Step("Скроллим до кнопки Пагинация")
    public ClientsPage scrollToPaginationButton() {
        paginationButton.scrollTo();

        return this;
    }

    @Step("Нажимаем кнопку Наверх")
    public ClientsPage goingBackUp() {
        upButton.shouldBe(visible).click();

        return this;
    }

    @Step("Проверяем, что кнопка Наверх исчезла")
    public ClientsPage checkVisibleUpButton() {
        upButton.shouldBe(hidden);

        return this;
    }

    @Step("Проверяем заголовок страницы")
    public ClientsPage checkTableHeader() {
        tableHeader.shouldBe(visible).shouldHave(Condition.exactText(TITLE_TEXT));

        return this;
    }
}
