package core.pages.authorization;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ForgotPasswordPage {

    private final String
            FORGOT_PASSWORD_TITLE_TEXT = "Забыли пароль ?",
            SENT_SUCCESSFULLY_MESSAGE = "Письмо с инструкциями отправлено !",
            INCORRECT_EMAIL = "Не корректный e-mail !",
            REQUIRED_FIELD = "Обязательное поле";

    // Локатор заголовка
    private SelenideElement
            forgotPasswordText = $(".css-v7yuct"),

    // Локаторы формы
    emailField = $("[name='email']"),
            sendButton = $(".css-19n6eea"),

    // Локатор уведомления под полем
    successMessage = $(".css-1xsto0d"),

    // Локатор ошибки
    errorEmailMessage = $("#email-helper-text");


    @Step("Проверяем заголовок формы")
    public ForgotPasswordPage checkTitleForm() {
        forgotPasswordText.shouldBe(visible).shouldHave(Condition.exactText(FORGOT_PASSWORD_TITLE_TEXT));

        return this;
    }

    @Step("Сбрасываем пароль")
    public ForgotPasswordPage passwordReset(String email) {
        emailField.shouldBe(visible).setValue(email);
        sendButton.shouldBe(visible).click();

        return this;
    }

    @Step("Кликаем на кнопку Отправить")
    public ForgotPasswordPage clickSendButton() {
        sendButton.shouldBe(visible).click();

        return this;
    }

    @Step("Проверяем, что высветилось сообщением об успешной отправке письма")
    public ForgotPasswordPage checkSuccessfullySentMessage() {
        successMessage.shouldBe(visible).shouldHave(Condition.exactText(SENT_SUCCESSFULLY_MESSAGE));

        return this;
    }

    @Step("Проверяем, что текст ошибки содержит: [{INCORRECT_EMAIL}]")
    public ForgotPasswordPage checkIncorrectEmail() {
        errorEmailMessage.shouldBe(visible).shouldHave(Condition.exactText(INCORRECT_EMAIL));

        return this;
    }

    @Step("Проверяем, что текст ошибки содержит: [{REQUIRED_FIELD}]")
    public ForgotPasswordPage checkRequiredField() {
        errorEmailMessage.shouldBe(visible).shouldHave(Condition.exactText(REQUIRED_FIELD));

        return this;
    }

    //
    @Step("Проверяем, что отображается ошибка c не найденным [{email}]")
    public ForgotPasswordPage checkUserNotFoundError(String email) {
        successMessage.shouldBe(visible).shouldHave(Condition.exactText("Пользователь с E-mail: " + email + " не найден !"));

        return this;
    }
}
