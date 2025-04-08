package core.pages.clients;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class ClientsPage {
    private final String
            TITLE_TEXT = "Таблица клиентов";

    private SelenideElement
            paginationButton = $("[data-testid='pagination-rows']"),
            upButton = $(".css-gbngva"),
            tableHeader = $(".css-1anx036"),
            paginationList = $("[data-testid='pagination-menu-list']");


    @Step("Скроллим до кнопки Пагинация")
    public ClientsPage scrollToPaginationButton() {
        paginationButton.shouldBe(visible).scrollTo();

        return this;
    }

    @Step("Выбираем нужный элемент пагинации")
    public ClientsPage clickPaginationButton(String value) {
        paginationButton.shouldBe(visible).click();
        paginationList.shouldBe(visible);
        SelenideElement paginationElement = $(String.format(".css-17p6f5[data-value='%s']", value));
        paginationElement.click();
        sleep(2000);

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
        sleep(3000);

        return this;
    }
}
