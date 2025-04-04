package core.pages.orders;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.components.SideBarComponent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OrdersPage extends SideBarComponent {
    private final String TITLE_TEXT = "Таблица заявок";

    // Локатор заголовка
    private SelenideElement
            titleText = $(".css-1anx036"),

    // Локаторы хедера
            newOrderButton = $("[data-button='создать_новую_заявку']"),
            commentsButton = $("[data-button='монитор_комментариев']");


    @Step("Проверяем заголовок страницы")
    public OrdersPage checkOrdersTitle() {
        titleText.shouldBe(visible).shouldHave(Condition.exactText(TITLE_TEXT));

        return this;
    }
}
